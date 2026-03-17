#!/usr/bin/env bb
;; check_vitality.bb - Eight Keys predicate: Vitality (φ)
;; Detects mechanical repetition and stale patterns
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

(defn find-duplicate-paragraphs [content file-path]
  (let [paragraphs (->> (str/split content #"\n\n+")
                        (map str/trim)
                        (filter #(> (count %) 50))
                        frequencies)]
    (for [[para cnt] paragraphs
          :when (> cnt 1)]
      {:key "vitality"
       :symbol "φ"
       :file file-path
       :line 0
       :content (subs para 0 (min 80 (count para)))
       :pattern (format "Duplicate paragraph (appears %d times)" cnt)
       :fix "Remove duplicate or consolidate into single reference"})))

(defn find-identical-structures [content file-path]
  (let [lines (str/split-lines content)
        line-patterns (for [line lines
                           :let [trimmed (str/trim line)]
                           :when (and (> (count trimmed) 30)
                                     (not (str/starts-with? trimmed "#"))
                                     (not (str/starts-with? trimmed "|")))]
                       trimmed)
        freqs (frequencies line-patterns)]
    (for [[line cnt] freqs
          :when (> cnt 2)
          :let [idx (first (keep-indexed (fn [i l] (when (= (str/trim l) line) i)) lines))]]
      {:key "vitality"
       :symbol "φ"
       :file file-path
       :line (inc idx)
       :content (subs line 0 (min 80 (count line)))
       :pattern (format "Identical line appears %d times" cnt)
       :fix "Extract to pattern or remove repetition"})))

(defn check-file [file-path]
  (let [content (slurp file-path)]
    (concat (find-duplicate-paragraphs content file-path)
            (find-identical-structures content file-path))))

(defn check-all [dir]
  (let [files (find-markdown-files dir)]
    (mapcat check-file files)))

(defn print-human [violations]
  (if (empty? violations)
    (println "✓ Vitality (φ): No mechanical repetition detected")
    (do
      (println (format "✗ Vitality (φ): %d violations found" (count violations)))
      (println "")
      (doseq [v violations]
        (println (format "  %s:%d" (:file v) (:line v)))
        (println (format "    Found: %s" (:pattern v)))
        (println (format "    Content: %s..." (:content v)))
        (println "")))))

(defn print-ci [violations]
  (let [output {:version "2.0.0"
                :mode "ci"
                :key "vitality"
                :symbol "φ"
                :violations violations
                :summary {:total (count violations)}}]
    (println (json/generate-string output {:pretty true}))))

(defn -main [& args]
  (let [{:keys [options errors]} (parse-opts args cli-options)]
    (if (or (:help options) (empty? args) errors)
      (do
        (println "Eight Keys Predicate: Vitality (φ)")
        (println "Detects mechanical repetition and stale patterns")
        (println "")
        (println "Usage:")
        (println "  bb check_vitality.bb -d .          # Check directory")
        (println "  bb check_vitality.bb -f README.md  # Check single file")
        (println "  bb check_vitality.bb -d . --ci     # JSON output for CI"))
      (let [violations (if-let [file (:file options)]
                         (check-file file)
                         (check-all (:dir options)))]
        (if (:ci options)
          (print-ci violations)
          (print-human violations))
        (System/exit (if (empty? violations) 0 1))))))

(apply -main *command-line-args*)