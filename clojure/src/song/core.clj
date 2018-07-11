(ns song.core
  (:require [clojure.pprint :as pprint])
  (:gen-class))

(def animals ["fly" "spider" "bird" "cat" "dog" "cow" "horse"])

(def comments ["I don't know why she swallowed a fly - perhaps she'll die!"
               "That wriggled and wiggled and tickled inside her."
               "How absurd to swallow a bird."
               "Fancy that to swallow a cat!"
               "What a hog, to swallow a dog!"
               "I don't know how she swallowed a cow!"
               "...She's dead, of course!"])

(def default-song (str "There was an old lady who swallowed a " (first animals) ".\n"
                       (first comments) "\n\n"
                       "There was an old lady who swallowed a " (second animals) ";\n"
                       (second comments) "\n"
                       "She swallowed the " (second animals) " to catch the fly;\n"
                       (first comments) "\n\n"
                       "There was an old lady who swallowed a " (nth animals 2) ";\n"
                       (nth comments 2) "\n"
                       "She swallowed the " (nth animals 2) " to catch the " (second animals) ",\n"
                       "She swallowed the " (second animals) " to catch the " (first animals) ";\n"
                       (first comments) "\n\n"
                       "There was an old lady who swallowed a " (nth animals 3) ";\n"
                       (nth comments 3) "\n"
                       "She swallowed the " (nth animals 3) " to catch the " (nth animals 2) ",\n"
                       "She swallowed the " (nth animals 2) " to catch the " (second animals) ",\n"
                       "She swallowed the " (second animals) " to catch the " (first animals) ";\n"
                       (first comments) "\n\n"
                       "There was an old lady who swallowed a " (nth animals 4) ";\n"
                       (nth comments 4) "\n"
                       "She swallowed the " (nth animals 4) " to catch the " (nth animals 3) ",\n"
                       "She swallowed the " (nth animals 3) " to catch the " (nth animals 2) ",\n"
                       "She swallowed the " (nth animals 2) " to catch the " (second animals) ",\n"
                       "She swallowed the " (second animals) " to catch the " (first animals) ";\n"
                       (first comments) "\n\n"
                       "There was an old lady who swallowed a " (nth animals 5) ";\n"
                       (nth comments 5) "\n"
                       "She swallowed the " (nth animals 5) " to catch the " (nth animals 4) ",\n"
                       "She swallowed the " (nth animals 4) " to catch the " (nth animals 3) ",\n"
                       "She swallowed the " (nth animals 3) " to catch the " (nth animals 2) ",\n"
                       "She swallowed the " (nth animals 2) " to catch the " (second animals) ",\n"
                       "She swallowed the " (second animals) " to catch the " (first animals) ";\n"
                       (first comments) "\n\n"
                       "There was an old lady who swallowed a " (nth animals 6) "...\n"
                       (nth comments 6) "\n"))

(defn sing [& args]
  default-song)

(defn -main [& args]
  (pprint/pprint default-song))
