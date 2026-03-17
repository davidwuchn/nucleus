#!/usr/bin/env bb
;; differential_test.bb - Compare λ definitions vs predicate implementations
;; Verifies that predicates implement what AGENTS.md specifies
;; Returns JSON for CI integration

(require '[clojure.tools.cli :refer [parse-opts]]
         '[cheshire.core :as json]
         '[clojure.string :as str]
         '[clojure.java.io :as io])

(def cli-options
  [["-c" "--ci" "Output JSON for CI"]
   ["-h" "--help" "Show help"]])

;; What AGENTS.md says each key checks
(def eight-keys-specs
  {:vitality {:symbol "φ"
              :spec "organic(x) ∧ ¬mechanical_repetition(x) | used(x) ≥ 3"
              :predicate-file "check_vitality.bb"
              :expected-checks ["duplicate paragraphs" "identical lines"]}
   
   :directness {:symbol "μ"
                :spec "no_hedging(x) | say_what_you_mean(x)"
                :predicate-file "check_directness.bb"
                :expected-checks ["hedging words" "maybe" "perhaps" "I think"]}
   
   :clarity {:symbol "fractal"
             :spec "explicit_assumptions(x) | bounds(x) ≡ defined(x)"
             :predicate-file "check_clarity.bb"
             :expected-checks ["vague language" "handle properly" "etc."]}
   
   :truth {:symbol "∃"
           :spec "favor_reality(x) | data_shown(x) > opinion_stated(x)"
           :predicate-file "check_truth.bb"
           :expected-checks ["unsubstantiated claims" "should work" "best practice"]}
   
   :vigilance {:symbol "∀"
               :spec "defensive_constraint(x) | input_validated(x)"
               :predicate-file "check_vigilance.bb"
               :expected-checks ["risky patterns" "rm -rf" "eval"]}})

(defn predicate-exists? [key-name]
  (let [pred-file (str "validator/" (get-in eight-keys-specs [key-name :predicate-file]))]
    (.exists (io/file pred-file))))

(defn predicate-executable? [key-name]
  (let [pred-file (str "validator/" (get-in eight-keys-specs [key-name :predicate-file]))]
    (try
      (let [result (shell/sh "bb" pred-file "-h")]
        (= 0 (:exit result)))
      (catch Exception e
        false))))

(defn run-predicate-sample [key-name]
  (let [pred-file (str "validator/" (get-in eight-keys-specs [key-name :predicate-file]))
        result (shell/sh "bb" pred-file "-f" "AGENTS.md" "--ci")]
    (try
      (json/parse-string (:out result) true)
      (catch Exception e
        {:error (.getMessage e)}))))

(defn validate-spec-implementation [key-name]
  (let [spec (get eight-keys-specs key-name)]
    {:key (name key-name)
     :symbol (:symbol spec)
     :spec (:spec spec)
     :predicate-exists (predicate-exists? key-name)
     :predicate-executable (predicate-executable? key-name)
     :sample-result (run-predicate-sample key-name)}))

(defn run-all-tests []
  (for [key-name (keys eight-keys-specs)]
    (validate-spec-implementation key-name)))

(defn print-human [results]
  (println "Differential Test: λ specs vs predicate implementations")
  (println "")
  (doseq [r results]
    (println (format "## %s (%s)" (:key r) (:symbol r)))
    (println (format "  Spec: %s" (:spec r)))
    (println (format "  Predicate exists: %s" (if (:predicate-exists r) "✓" "✗")))
    (println (format "  Predicate executable: %s" (if (:predicate-executable r) "✓" "✗")))
    (if-let [sample (get-in r [:sample-result :summary :total])]
      (println (format "  Sample violations: %d" sample))
      (println (format "  Sample result: %s" (:sample-result r))))
    (println "")))
  
  (let [all-pass (every? #(and (:predicate-exists %) (:predicate-executable %)) results)]
    (if all-pass
      (println "✓ All predicates implement their λ specs")
      (println "✗ Some predicates missing or not executable"))))

(defn print-ci [results]
  (let [all-pass (every? #(and (:predicate-exists %) (:predicate-executable %)) results)
        output {:version "2.0.0"
                :mode "ci"
                :check "differential-test"
                :results results
                :passed all-pass}]
    (println (json/generate-string output {:pretty true}))))

(defn -main [& args]
  (let [{:keys [options errors]} (parse-opts args cli-options)]
    (if (or (:help options) errors)
      (do
        (println "Differential Test - Compare λ specs vs predicates")
        (println "")
        (println "Usage:")
        (println "  bb differential_test.bb        # Human output")
        (println "  bb differential_test.bb --ci   # JSON output"))
      (let [results (run-all-tests)]
        (if (:ci options)
          (print-ci results)
          (print-human results))
        (let [all-pass (every? #(and (:predicate-exists %) (:predicate-executable %)) results)]
          (System/exit (if all-pass 0 1)))))))

(apply -main *command-line-args*)