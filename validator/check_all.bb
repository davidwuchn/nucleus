#!/usr/bin/env bb
;; check_all.bb - Run all Eight Keys predicates
;; Aggregates results from individual key checks

(require '[clojure.tools.cli :refer [parse-opts]]
         '[cheshire.core :as json]
         '[clojure.java.shell :refer [sh]]
         '[clojure.string :as str])

(def cli-options
  [["-d" "--dir PATH" "Directory to check" :default "."]
   ["-c" "--ci" "Output JSON for CI"]
   ["-k" "--key KEY" "Check specific key only"]
   ["-h" "--help" "Show help"]])

(def predicates
  [{:key "vitality" :symbol "φ" :script "check_vitality.bb"}
   {:key "directness" :symbol "μ" :script "check_directness.bb"}
   {:key "clarity" :symbol "fractal" :script "check_clarity.bb"}
   {:key "truth" :symbol "∃" :script "check_truth.bb"}
   {:key "vigilance" :symbol "∀" :script "check_vigilance.bb"}])

(defn run-predicate [predicate dir ci-mode]
  (let [script-path (str "validator/" (:script predicate))
        args (concat ["bb" script-path "-d" dir]
                     (when ci-mode ["--ci"]))]
    (try
      (let [result (apply sh args)]
        (if ci-mode
          (try
            (json/parse-string (:out result) true)
            (catch Exception e
              {:error (.getMessage e)}))
          {:key (:key predicate)
           :symbol (:symbol predicate)
           :output (:out result)
           :exit (:exit result)}))
      (catch Exception e
        {:error (.getMessage e)}))))

(defn print-human [results]
  (doseq [r results]
    (if (:error r)
      (println (format "✗ %s (%s): Error - %s" (:key r) (:symbol r) (:error r)))
      (print (:output r))))
  (let [exit-codes (keep :exit results)
        total-failures (count (filter #(> % 0) exit-codes))]
    (println "")
    (if (zero? total-failures)
      (println "✓ All Eight Keys checks passed")
      (println (format "✗ %d key(s) had violations" total-failures)))))

(defn print-ci [results]
  (let [total (reduce + (map #(get-in % [:summary :total] 0) results))
        output {:version "2.0.0"
                :mode "ci"
                :results results
                :summary {:total total
                          :by_key (into {} (map (fn [r]
                                                 [(keyword (:key r))
                                                  (get-in r [:summary :total] 0)])
                                               results))}}]
    (println (json/generate-string output {:pretty true}))))

(defn -main [& args]
  (let [{:keys [options errors]} (parse-opts args cli-options)]
    (if (or (:help options) (empty? args) errors)
      (do
        (println "Eight Keys Predicates - Run All Checks")
        (println "")
        (println "Usage:")
        (println "  bb check_all.bb -d .          # Check directory")
        (println "  bb check_all.bb -d . --ci     # JSON output for CI")
        (println "  bb check_all.bb -d . -k truth # Check specific key")
        (println "")
        (println "Available keys:")
        (doseq [p predicates]
          (println (format "  %s (%s)" (:key p) (:symbol p)))))
      (let [preds-to-run (if-let [specific-key (:key options)]
                           (filter #(= (:key %) specific-key) predicates)
                           predicates)
            results (map #(run-predicate % (:dir options) (:ci options))
                         preds-to-run)]
        (if (:ci options)
          (print-ci results)
          (print-human results))
        (let [exit-codes (keep :exit results)
              total-failures (count (filter #(> % 0) exit-codes))]
          (System/exit (if (zero? total-failures) 0 1)))))))

(apply -main *command-line-args*)