(ns song.core
  (:require [clojure.pprint :as pprint])
  (:gen-class))

(def animals ["fly" "spider" "bird" "cat" "dog" "cow" "horse"])

(def default-song (str "There was an old lady who swallowed a " (first animals) ".\n"
                       "I don't know why she swallowed a " (first animals) " - perhaps she'll die!\n\n"
                       "There was an old lady who swallowed a " (second animals) ";\n"
                       "That wriggled and wiggled and tickled inside her.\n"
                       "She swallowed the " (second animals) " to catch the fly;\n"
                       "I don't know why she swallowed a " (first animals) " - perhaps she'll die!\n\n"
                       "There was an old lady who swallowed a " (nth animals 2) ";\n"
                       "How absurd to swallow a " (nth animals 2) ".\n"
                       "She swallowed the " (nth animals 2) " to catch the " (second animals) ",\n"
                       "She swallowed the " (second animals) " to catch the " (first animals) ";\n"
                       "I don't know why she swallowed a " (first animals) " - perhaps she'll die!\n\n"
                       "There was an old lady who swallowed a " (nth animals 3) ";\n"
                       "Fancy that to swallow a " (nth animals 3) "!\n"
                       "She swallowed the " (nth animals 3) " to catch the " (nth animals 2) ",\n"
                       "She swallowed the " (nth animals 2) " to catch the " (second animals) ",\n"
                       "She swallowed the " (second animals) " to catch the " (first animals) ";\n"
                       "I don't know why she swallowed a " (first animals) " - perhaps she'll die!\n\n"
                       "There was an old lady who swallowed a " (nth animals 4) ";\n"
                       "What a hog, to swallow a " (nth animals 4) "!\n"
                       "She swallowed the " (nth animals 4) " to catch the " (nth animals 3) ",\n"
                       "She swallowed the " (nth animals 3) " to catch the " (nth animals 2) ",\n"
                       "She swallowed the " (nth animals 2) " to catch the " (second animals) ",\n"
                       "She swallowed the " (second animals) " to catch the " (first animals) ";\n"
                       "I don't know why she swallowed a " (first animals) " - perhaps she'll die!\n\n"
                       "There was an old lady who swallowed a " (nth animals 5) ";\n"
                       "I don't know how she swallowed a " (nth animals 5) "!\n"
                       "She swallowed the " (nth animals 5) " to catch the " (nth animals 4) ",\n"
                       "She swallowed the " (nth animals 4) " to catch the " (nth animals 3) ",\n"
                       "She swallowed the " (nth animals 3) " to catch the " (nth animals 2) ",\n"
                       "She swallowed the " (nth animals 2) " to catch the " (second animals) ",\n"
                       "She swallowed the " (second animals) " to catch the " (first animals) ";\n"
                       "I don't know why she swallowed a " (first animals) " - perhaps she'll die!\n\n"
                       "There was an old lady who swallowed a " (nth animals 6) "...\n"
                       "...She's dead, of course!\n"))

(defn sing [& args]
  default-song)

(defn -main [& args]
  (pprint/pprint default-song))
