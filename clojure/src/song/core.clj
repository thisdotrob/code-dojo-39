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

(defn animals->swallowed-catched-line [animals]
  (str "She swallowed the " (first animals) " to catch the " (second animals)))

(defn animal->swallowed-a-line [animal]
  (str "There was an old lady who swallowed a " animal))

(def default-song (str (animal->swallowed-a-line (first animals)) ".\n"
                       (first comments) "\n\n"
                       (animal->swallowed-a-line (second animals)) ";\n"
                       (second comments) "\n"
                       (animals->swallowed-catched-line [(second animals) (first animals)]) ";\n"
                       (first comments) "\n\n"
                       (animal->swallowed-a-line (nth animals 2)) ";\n"
                       (nth comments 2) "\n"
                       (animals->swallowed-catched-line [(nth animals 2) (second animals)]) ",\n"
                       (animals->swallowed-catched-line [(second animals) (first animals)]) ";\n"
                       (first comments) "\n\n"
                       (animal->swallowed-a-line (nth animals 3)) ";\n"
                       (nth comments 3) "\n"
                       (animals->swallowed-catched-line [(nth animals 3) (nth animals 2)]) ",\n"
                       (animals->swallowed-catched-line [(nth animals 2) (second animals)]) ",\n"
                       (animals->swallowed-catched-line [(second animals) (first animals)]) ";\n"
                       (first comments) "\n\n"
                       (animal->swallowed-a-line (nth animals 4)) ";\n"
                       (nth comments 4) "\n"
                       (animals->swallowed-catched-line [(nth animals 4) (nth animals 3)]) ",\n"
                       (animals->swallowed-catched-line [(nth animals 3) (nth animals 2)]) ",\n"
                       (animals->swallowed-catched-line [(nth animals 2) (second animals)]) ",\n"
                       (animals->swallowed-catched-line [(second animals) (first animals)]) ";\n"
                       (first comments) "\n\n"
                       (animal->swallowed-a-line (nth animals 5)) ";\n"
                       (nth comments 5) "\n"
                       (animals->swallowed-catched-line [(nth animals 5) (nth animals 4)]) ",\n"
                       (animals->swallowed-catched-line [(nth animals 4) (nth animals 3)]) ",\n"
                       (animals->swallowed-catched-line [(nth animals 3) (nth animals 2)]) ",\n"
                       (animals->swallowed-catched-line [(nth animals 2) (second animals)]) ",\n"
                       (animals->swallowed-catched-line [(second animals) (first animals)]) ";\n"
                       (first comments) "\n\n"
                       (animal->swallowed-a-line (nth animals 6)) "...\n"
                       (nth comments 6) "\n"))

(defn sing [& args]
  default-song)

(defn -main [& args]
  (pprint/pprint default-song))
