#!/usr/bin/env bb
;; check_directness.bb - Eight Keys predicate: Directness (μ)
;; Detects hedging language that violates directness principle
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

(def hedging-patterns
  [{:pattern #"(?i)\bmaybe\b" :suggestion "Remove 'maybe' - be direct"}
   {:pattern #"(?i)\bperhaps\b" :suggestion "Remove 'perhaps' - be direct"}
   {:pattern #"(?i)\bmight possibly\b" :suggestion "Remove 'might possibly' - be direct"}
   {:pattern #"(?i)\bcould potentially\b" :suggestion "Remove 'could potentially' - be direct"}
   {:pattern #"(?i)\bseems to\b" :suggestion "Replace 'seems to' with direct statement"}
   {:pattern #"(?i)\bappears to\b" :suggestion "Replace 'appears to' with direct statement"}
   {:pattern #"(?i)\bnot sure if\b" :suggestion "Remove 'not sure if' - state clearly or ask"}
   {:pattern #"(?i)\bI think\b" :suggestion "Remove 'I think' - state as fact or show data"}
   {:pattern #"(?i)\bsort of\b" :suggestion "Remove 'sort of' - be precise"}
   {:pattern #"(?i)\bkind of\b" :suggestion "Remove 'kind of' - be precise"}
   {:pattern #"(?i)\bsomewhat\b" :suggestion "Remove 'somewhat' - be precise or quantify"}
   {:pattern #"(?i)\bprobably\b" :suggestion "Replace 'probably' with data or certainty"}])

(def default-exclusions
  ;; Memory - personal learning
  ["memories/"
   
   ;; Philosophy - speculative, not executable
   "PHILOSOPHY_RESEARCH.md"
   
   ;; Historical - records of past work
   "PHASE_"
   "_COMPLETE.md"
   "_SUMMARY.md"
   "CHANGELOG.md"
   "README_IMPROVEMENTS.md"
   "EQUATIONS_FOR_WORLD.md"
   
   ;; Games - creative fiction
   "NUCLEUS_GAME.md"
   "RECURSIVE_DEPTHS.md"
   
   ;; Demos - test outputs
   "ADAPTIVE.md"
   "DIALECTIC.md"
   
   ;; Editor-specific
   "eca/"
   
   ;; Upstream files - not modifiable
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
    (for [hedging hedging-patterns
          :let [pattern (:pattern hedging)]
          [idx line] (map-indexed vector lines)
          :when (re-find pattern line)]
      {:key "directness"
       :symbol "μ"
       :file file-path
       :line (inc idx)
       :content (str/trim line)
       :pattern (str (re-find pattern line))
       :fix (:suggestion hedging)})))

(defn check-all [dir]
  (let [files (find-markdown-files dir)]
    (mapcat check-file files)))

(defn print-human [violations]
  (if (empty? violations)
    (println "✓ Directness (μ): No hedging detected")
    (do
      (println (format "✗ Directness (μ): %d violations found" (count violations)))
      (println "")
      (doseq [v violations]
        (println (format "  %s:%d" (:file v) (:line v)))
        (println (format "    Found: %s" (:pattern v)))
        (println (format "    Fix: %s" (:fix v)))
        (println "")))))

(defn print-ci [violations]
  (let [output {:version "2.0.0"
                :mode "ci"
                :key "directness"
                :symbol "μ"
                :violations violations
                :summary {:total (count violations)}}]
    (println (json/generate-string output {:pretty true}))))

(defn -main [& args]
  (let [{:keys [options errors]} (parse-opts args cli-options)]
    (if (or (:help options) (empty? args) errors)
      (do
        (println "Eight Keys Predicate: Directness (μ)")
        (println "Detects hedging language in markdown files")
        (println "")
        (println "Usage:")
        (println "  bb check_directness.bb -d .          # Check directory")
        (println "  bb check_directness.bb -f README.md  # Check single file")
        (println "  bb check_directness.bb -d . --ci     # JSON output for CI"))
      (let [violations (if-let [file (:file options)]
                         (check-file file)
                         (check-all (:dir options)))]
        (if (:ci options)
          (print-ci violations)
          (print-human violations))
        (System/exit (if (empty? violations) 0 1))))))

(apply -main *command-line-args*)