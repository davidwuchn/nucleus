#!/usr/bin/env bb
;; check_code_boundary.bb - Verify code mode boundary
;; Detects: unrequested features, scope creep, "while I'm here" changes

(require '[clojure.tools.cli :refer [parse-opts]]
         '[cheshire.core :as json]
         '[clojure.string :as str]
         '[clojure.java.io :as io])

(def cli-options
  [["-f" "--file PATH" "File to check"]
   ["-d" "--dir PATH" "Directory to check" :default "."]
   ["-c" "--ci" "Output JSON for CI"]
   ["-h" "--help" "Show help"]])

(def scope-creep-patterns
  [{:pattern #"(?i)while I'?m here" :suggestion "Remove 'while I'm here' - scope creep indicator"}
   {:pattern #"(?i)I also (added|fixed|refactored)" :suggestion "Check if this was requested"}
   {:pattern #"(?i)noticed.*could be improved" :suggestion "Improvement not in scope - document separately"}
   {:pattern #"(?i)bonus:" :suggestion "Remove bonus changes - not in scope"}
   {:pattern #"(?i)extra:" :suggestion "Remove extra changes - not in scope"}
   {:pattern #"(?i)as a bonus" :suggestion "Remove bonus - violates code mode boundary"}
   {:pattern #"(?i)I went ahead and" :suggestion "Verify this was requested"}])

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
    (for [pattern scope-creep-patterns
          :let [p (:pattern pattern)]
          [idx line] (map-indexed vector lines)
          :when (re-find p line)]
      {:key "code-boundary"
       :mode "#=code"
       :file file-path
       :line (inc idx)
       :content (str/trim line)
       :pattern (str (re-find p line))
       :fix (:suggestion pattern)})))

(defn check-all [dir]
  (let [files (find-markdown-files dir)]
    (mapcat check-file files)))

(defn print-human [violations]
  (if (empty? violations)
    (println "✓ Code boundary: No scope creep detected")
    (do
      (println (format "✗ Code boundary: %d potential scope creep issues" (count violations)))
      (println "")
      (doseq [v violations]
        (println (format "  %s:%d" (:file v) (:line v)))
        (println (format "    Found: %s" (:pattern v)))
        (println (format "    Fix: %s" (:fix v)))
        (println "")))))

(defn print-ci [violations]
  (let [output {:version "2.0.0"
                :mode "ci"
                :check "code-boundary"
                :violations violations
                :summary {:total (count violations)}}]
    (println (json/generate-string output {:pretty true}))))

(defn -main [& args]
  (let [{:keys [options errors]} (parse-opts args cli-options)]
    (if (or (:help options) (empty? args) errors)
      (do
        (println "Code Boundary Check - Detect scope creep")
        (println "Checks for: 'while I'm here', unrequested features, scope creep")
        (println "")
        (println "Usage:")
        (println "  bb check_code_boundary.bb -d . --ci"))
      (let [violations (if-let [file (:file options)]
                         (check-file file)
                         (check-all (:dir options)))]
        (if (:ci options)
          (print-ci violations)
          (print-human violations))
        (System/exit (if (empty? violations) 0 1))))))

(apply -main *command-line-args*)