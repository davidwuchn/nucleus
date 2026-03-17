#!/usr/bin/env bb
;; check_truth.bb - Eight Keys predicate: Truth (∃)
;; Detects unsubstantiated claims and opinion without data
;; Returns JSON for CI integration

(require '[clojure.tools.cli :refer [parse-opts]]
         '[cheshire.core :as json]
         '[clojure.string :as str]
         '[clojure.java.io :as io])

(def cli-options
  [["-f" "--file PATH" "Single file to check"]
   ["-d" "--dir PATH" "Directory to check" :default "."]
   ["-c" "--ci" "Output JSON for CI"]
   ["-h" "--help" "Show help"]])

(def unsubstantiated-patterns
  [{:pattern #"(?i)should work" :suggestion "Show test results or data demonstrating it works"}
   {:pattern #"(?i)probably works" :suggestion "Provide evidence of functionality"}
   {:pattern #"(?i)I believe" :suggestion "Replace with data or citation"}
   {:pattern #"(?i)I feel (like|that)" :suggestion "Replace feeling with data"}
   {:pattern #"(?i)in my opinion" :suggestion "State as fact with evidence or mark as subjective"}
   {:pattern #"(?i)it seems (like|that)" :suggestion "Show data or remove hedging"}
   {:pattern #"(?i)obviously" :suggestion "If obvious, show why; if not, remove"}
   {:pattern #"(?i)clearly" :suggestion "Show evidence instead of asserting clarity"}
   {:pattern #"(?i)everyone knows" :suggestion "Cite source or remove assertion"}
   {:pattern #"(?i)it's well known" :suggestion "Provide citation"}
   {:pattern #"(?i)best practice" :suggestion "Cite source or explain why it's best"}
   {:pattern #"(?i)industry standard" :suggestion "Cite specific standard"}])

(def default-exclusions
  ["memories/"
   "PHILOSOPHY_RESEARCH.md"
   "PHASE_"
   "_COMPLETE.md"
   "_SUMMARY.md"
   "CHANGELOG.md"
   "README_IMPROVEMENTS.md"
   "EQUATIONS_FOR_WORLD.md"
   "NUCLEUS_GAME.md"
   "RECURSIVE_DEPTHS.md"
   "ADAPTIVE.md"
   "DIALECTIC.md"
   "eca/"
   "README.md"
   "SYMBOLIC_FRAMEWORK.md"])

(defn excluded? [file-path]
  (some (fn [excl]
          (or (str/includes? file-path excl)
              (str/ends-with? file-path excl)))
        default-exclusions))

(defn find-markdown-files [dir]
  (let [base-dir (io/file dir)]
    (if (not (.exists base-dir))
      []
      (->> (file-seq base-dir)
           (filter #(.isFile %))
           (filter #(let [path (.getPath %)]
                     (or (str/ends-with? path ".md")
                         (str/ends-with? path ".markdown"))))
           (map #(.getPath %))
           (remove excluded?)))))

(defn check-file [file-path]
  (let [content (slurp file-path)
        lines (str/split-lines content)]
    (for [claim unsubstantiated-patterns
          :let [pattern (:pattern claim)]
          [idx line] (map-indexed vector lines)
          :when (re-find pattern line)]
      {:key "truth"
       :symbol "∃"
       :file file-path
       :line (inc idx)
       :content (str/trim line)
       :pattern (str (re-find pattern line))
       :fix (:suggestion claim)})))

(defn check-all [dir]
  (let [files (find-markdown-files dir)]
    (mapcat check-file files)))

(defn print-human [violations]
  (if (empty? violations)
    (println "✓ Truth (∃): No unsubstantiated claims detected")
    (do
      (println (format "✗ Truth (∃): %d violations found" (count violations)))
      (println "")
      (doseq [v violations]
        (println (format "  %s:%d" (:file v) (:line v)))
        (println (format "    Found: %s" (:pattern v)))
        (println (format "    Fix: %s" (:fix v)))
        (println "")))))

(defn print-ci [violations]
  (let [output {:version "2.0.0"
                :mode "ci"
                :key "truth"
                :symbol "∃"
                :violations violations
                :summary {:total (count violations)}}]
    (println (json/generate-string output {:pretty true}))))

(defn -main [& args]
  (let [{:keys [options errors]} (parse-opts args cli-options)]
    (if (or (:help options) (empty? args) errors)
      (do
        (println "Eight Keys Predicate: Truth (∃)")
        (println "Detects unsubstantiated claims and opinion without data")
        (println "")
        (println "Usage:")
        (println "  bb check_truth.bb -d .          # Check directory")
        (println "  bb check_truth.bb -f README.md  # Check single file")
        (println "  bb check_truth.bb -d . --ci     # JSON output for CI"))
      (let [violations (if-let [file (:file options)]
                         (check-file file)
                         (check-all (:dir options)))]
        (if (:ci options)
          (print-ci violations)
          (print-human violations))
        (System/exit (if (empty? violations) 0 1))))))

(apply -main *command-line-args*)