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

(def double-new-line "\n\n")

(def new-line "\n")

(def semi-colon-new-line ";\n")

(def comma-new-line ",\n")

(def full-stop-new-line ".\n")

(def ellipsis-new-line "...\n")

(def default-song (str (animal->swallowed-a-line (first animals)) full-stop-new-line
                       (first comments) double-new-line
                       (animal->swallowed-a-line (second animals)) semi-colon-new-line
                       (second comments) new-line
                       (animals->swallowed-catched-line [(second animals) (first animals)]) semi-colon-new-line
                       (first comments) double-new-line
                       (animal->swallowed-a-line (nth animals 2)) semi-colon-new-line
                       (nth comments 2) new-line
                       (animals->swallowed-catched-line [(nth animals 2) (second animals)]) comma-new-line
                       (animals->swallowed-catched-line [(second animals) (first animals)]) semi-colon-new-line
                       (first comments) double-new-line
                       (animal->swallowed-a-line (nth animals 3)) semi-colon-new-line
                       (nth comments 3) new-line
                       (animals->swallowed-catched-line [(nth animals 3) (nth animals 2)]) comma-new-line
                       (animals->swallowed-catched-line [(nth animals 2) (second animals)]) comma-new-line
                       (animals->swallowed-catched-line [(second animals) (first animals)]) semi-colon-new-line
                       (first comments) double-new-line
                       (animal->swallowed-a-line (nth animals 4)) semi-colon-new-line
                       (nth comments 4) new-line
                       (animals->swallowed-catched-line [(nth animals 4) (nth animals 3)]) comma-new-line
                       (animals->swallowed-catched-line [(nth animals 3) (nth animals 2)]) comma-new-line
                       (animals->swallowed-catched-line [(nth animals 2) (second animals)]) comma-new-line
                       (animals->swallowed-catched-line [(second animals) (first animals)]) semi-colon-new-line
                       (first comments) double-new-line
                       (animal->swallowed-a-line (nth animals 5)) semi-colon-new-line
                       (nth comments 5) new-line
                       (animals->swallowed-catched-line [(nth animals 5) (nth animals 4)]) comma-new-line
                       (animals->swallowed-catched-line [(nth animals 4) (nth animals 3)]) comma-new-line
                       (animals->swallowed-catched-line [(nth animals 3) (nth animals 2)]) comma-new-line
                       (animals->swallowed-catched-line [(nth animals 2) (second animals)]) comma-new-line
                       (animals->swallowed-catched-line [(second animals) (first animals)]) semi-colon-new-line
                       (first comments) double-new-line
                       (animal->swallowed-a-line (nth animals 6)) ellipsis-new-line
                       (nth comments 6) new-line))

(defn sing [& args]
  default-song)

(defn -main [& args]
  (pprint/pprint default-song))
