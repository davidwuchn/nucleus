#!/usr/bin/env bb
;; verify_instincts.bb - Verify instincts have proper metadata and are actionable
;; Returns JSON for CI integration

(require '[clojure.tools.cli :refer [parse-opts]]
         '[cheshire.core :as json]
         '[clojure.string :as str]
         '[clojure.java.io :as io])

(def cli-options
  [["-d" "--dir PATH" "Directory to check" :default "skills/continuous-learning/instincts"]
   ["-c" "--ci" "Output JSON for CI"]
   ["-h" "--help" "Show help"]])

(def required-frontmatter
  [:name :domain :φ :e :λ :source])

(defn parse-frontmatter [content]
  (when-let [match (re-find #"(?s)^---\s*\n(.*?)\n---" content)]
    (let [yaml-str (second match)
          lines (str/split-lines yaml-str)]
      (into {}
            (for [line lines
                  :let [[_ key val] (re-find #"^(\S+):\s*(.*)$" line)]
                  :when key]
              [(keyword key) (str/trim val)])))))

(defn check-instinct [file-path]
  (let [content (slurp file-path)
        frontmatter (parse-frontmatter content)
        violations []]
    (cond
      (nil? frontmatter)
      [{:file file-path
        :violation "Missing frontmatter"
        :fix "Add YAML frontmatter with required fields"}]
      
      :else
      (let [missing (remove #(contains? frontmatter %) required-frontmatter)]
        (if (seq missing)
          [{:file file-path
            :violation (str "Missing required fields: " (str/join ", " (map name missing)))
            :fix "Add missing frontmatter fields"}]
          [])))))

(defn find-instinct-files [dir]
  (let [base-dir (io/file dir)]
    (if (not (.exists base-dir))
      []
      (->> (file-seq base-dir)
           (filter #(.isFile %))
           (filter #(.endsWith (.getName %) ".md"))
           (map #(.getPath %))))))

(defn check-all [dir]
  (let [files (find-instinct-files dir)]
    (mapcat check-instinct files)))

(defn print-human [violations]
  (if (empty? violations)
    (println "✓ All instincts have valid frontmatter")
    (do
      (println (format "✗ %d instinct violations found" (count violations)))
      (println "")
      (doseq [v violations]
        (println (format "  %s" (:file v)))
        (println (format "    Violation: %s" (:violation v)))
        (println (format "    Fix: %s" (:fix v)))
        (println "")))))

(defn print-ci [violations]
  (let [output {:version "2.0.0"
                :mode "ci"
                :check "instinct-verification"
                :violations violations
                :summary {:total (count violations)}}]
    (println (json/generate-string output {:pretty true}))))

(defn -main [& args]
  (let [{:keys [options errors]} (parse-opts args cli-options)]
    (if (or (:help options) (empty? args) errors)
      (do
        (println "Instinct Verification - Check frontmatter and structure")
        (println "")
        (println "Usage:")
        (println "  bb verify_instincts.bb -d skills/continuous-learning/instincts")
        (println "  bb verify_instincts.bb -d . --ci  # JSON output"))
      (let [violations (check-all (:dir options))]
        (if (:ci options)
          (print-ci violations)
          (print-human violations))
        (System/exit (if (empty? violations) 0 1))))))

(apply -main *command-line-args*)