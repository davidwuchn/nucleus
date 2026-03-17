#!/usr/bin/env bb
;; check_clarity.bb - Eight Keys predicate: Clarity (fractal)
;; Detects vague language and undefined bounds
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

(def vague-patterns
  [{:pattern #"(?i)handle properly" :suggestion "Define explicit handling: 'validate ∈ [MIN, MAX]'"}
   {:pattern #"(?i)handle correctly" :suggestion "Define explicit correct handling"}
   {:pattern #"(?i)handle appropriately" :suggestion "Define what appropriate means"}
   {:pattern #"(?i)handle edge cases" :suggestion "List specific edge cases"}
   {:pattern #"(?i)deal with" :suggestion "Specify how to deal with it"}
   {:pattern #"(?i)as needed" :suggestion "Define when it's needed"}
   {:pattern #"(?i)as required" :suggestion "Define what's required"}
   {:pattern #"(?i)etc\." :suggestion "Complete the list instead of 'etc.'"}
   {:pattern #"(?i)and so on" :suggestion "Complete the list explicitly"}
   {:pattern #"(?i)various things" :suggestion "List specific things"}
   {:pattern #"(?i)some way" :suggestion "Specify the exact way"}
   {:pattern #"(?i)in some cases" :suggestion "Specify which cases"}])

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
    (for [vague vague-patterns
          :let [pattern (:pattern vague)]
          [idx line] (map-indexed vector lines)
          :when (re-find pattern line)]
      {:key "clarity"
       :symbol "fractal"
       :file file-path
       :line (inc idx)
       :content (str/trim line)
       :pattern (str (re-find pattern line))
       :fix (:suggestion vague)})))

(defn check-all [dir]
  (let [files (find-markdown-files dir)]
    (mapcat check-file files)))

(defn print-human [violations]
  (if (empty? violations)
    (println "✓ Clarity (fractal): No vague language detected")
    (do
      (println (format "✗ Clarity (fractal): %d violations found" (count violations)))
      (println "")
      (doseq [v violations]
        (println (format "  %s:%d" (:file v) (:line v)))
        (println (format "    Found: %s" (:pattern v)))
        (println (format "    Fix: %s" (:fix v)))
        (println "")))))

(defn print-ci [violations]
  (let [output {:version "2.0.0"
                :mode "ci"
                :key "clarity"
                :symbol "fractal"
                :violations violations
                :summary {:total (count violations)}}]
    (println (json/generate-string output {:pretty true}))))

(defn -main [& args]
  (let [{:keys [options errors]} (parse-opts args cli-options)]
    (if (or (:help options) (empty? args) errors)
      (do
        (println "Eight Keys Predicate: Clarity (fractal)")
        (println "Detects vague language and undefined bounds")
        (println "")
        (println "Usage:")
        (println "  bb check_clarity.bb -d .          # Check directory")
        (println "  bb check_clarity.bb -f README.md  # Check single file")
        (println "  bb check_clarity.bb -d . --ci     # JSON output for CI"))
      (let [violations (if-let [file (:file options)]
                         (check-file file)
                         (check-all (:dir options)))]
        (if (:ci options)
          (print-ci violations)
          (print-human violations))
        (System/exit (if (empty? violations) 0 1))))))

(apply -main *command-line-args*)