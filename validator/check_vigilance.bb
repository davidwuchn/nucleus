#!/usr/bin/env bb
;; check_vigilance.bb - Eight Keys predicate: Vigilance (∀)
;; Detects missing input validation and defensive coding issues
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

(def risky-patterns
  [{:pattern #"(?i)rm\s+-rf" :suggestion "Add safety check: validate path before rm -rf"}
   {:pattern #"(?i)eval\s*\(" :suggestion "Validate input before eval - injection risk"}
   {:pattern #"(?i)exec\s*\(" :suggestion "Validate/sanitize input before exec"}
   {:pattern #"(?i)system\s*\(" :suggestion "Validate/sanitize input before system call"}
   {:pattern #"(?i)shell\s*\(" :suggestion "Validate/sanitize shell input"}
   {:pattern #"(?i)sudo\s+" :suggestion "Document why sudo is needed, validate context"}
   {:pattern #"(?i)chmod\s+777" :suggestion "Use specific permissions, not 777"}
   {:pattern #"(?i)curl\s+.*\|\s*(bash|sh)" :suggestion "Download and verify before executing"}
   {:pattern #"(?i)wget\s+.*\|\s*(bash|sh)" :suggestion "Download and verify before executing"}
   {:pattern #"(?i)\$_GET" :suggestion "Validate/sanitize user input"}
   {:pattern #"(?i)\$_POST" :suggestion "Validate/sanitize user input"}
   {:pattern #"(?i)request\.args" :suggestion "Validate Flask request args"}
   {:pattern #"(?i)params\[" :suggestion "Validate Rails params"}])

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
    (for [risky risky-patterns
          :let [pattern (:pattern risky)]
          [idx line] (map-indexed vector lines)
          :when (re-find pattern line)]
      {:key "vigilance"
       :symbol "∀"
       :file file-path
       :line (inc idx)
       :content (str/trim line)
       :pattern (str (re-find pattern line))
       :fix (:suggestion risky)})))

(defn check-all [dir]
  (let [files (find-markdown-files dir)]
    (mapcat check-file files)))

(defn print-human [violations]
  (if (empty? violations)
    (println "✓ Vigilance (∀): No risky patterns detected")
    (do
      (println (format "✗ Vigilance (∀): %d violations found" (count violations)))
      (println "")
      (doseq [v violations]
        (println (format "  %s:%d" (:file v) (:line v)))
        (println (format "    Found: %s" (:pattern v)))
        (println (format "    Fix: %s" (:fix v)))
        (println "")))))

(defn print-ci [violations]
  (let [output {:version "2.0.0"
                :mode "ci"
                :key "vigilance"
                :symbol "∀"
                :violations violations
                :summary {:total (count violations)}}]
    (println (json/generate-string output {:pretty true}))))

(defn -main [& args]
  (let [{:keys [options errors]} (parse-opts args cli-options)]
    (if (or (:help options) (empty? args) errors)
      (do
        (println "Eight Keys Predicate: Vigilance (∀)")
        (println "Detects missing input validation and risky patterns")
        (println "")
        (println "Usage:")
        (println "  bb check_vigilance.bb -d .          # Check directory")
        (println "  bb check_vigilance.bb -f README.md  # Check single file")
        (println "  bb check_vigilance.bb -d . --ci     # JSON output for CI"))
      (let [violations (if-let [file (:file options)]
                         (check-file file)
                         (check-all (:dir options)))]
        (if (:ci options)
          (print-ci violations)
          (print-human violations))
        (System/exit (if (empty? violations) 0 1))))))

(apply -main *command-line-args*)