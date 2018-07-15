(ns song.core
  (:require [clojure.pprint :as pprint]
            [clojure.string :as string])
  (:gen-class))

(def animals ["fly" "spider" "bird" "cat" "dog" "cow" "horse"])

(def comments ["I don't know why she swallowed a fly - perhaps she'll die!"
               "That wriggled and wiggled and tickled inside her."
               "How absurd to swallow a bird."
               "Fancy that to swallow a cat!"
               "What a hog, to swallow a dog!"
               "I don't know how she swallowed a cow!"
               "...She's dead, of course!"])

(defn animals->swallowed-catched-line [[animal-1 animal-2]]
  (str "She swallowed the " animal-1 " to catch the " animal-2))

(defn animal->swallowed-a-line [animal]
  (str "There was an old lady who swallowed a " animal))

(def double-new-line "\n\n")

(def new-line "\n")

(def semi-colon-new-line ";\n")

(def comma-new-line ",\n")

(def full-stop-new-line ".\n")

(def ellipsis-new-line "...\n")

(defn make-pairs [xs]
  (let [map-fn (fn [idx] [(nth xs idx) (nth xs (+ idx 1))])
        indexes (range (- (count xs) 1))]
    (map map-fn indexes)))

(defn animals->swallowed-catched-lines [animals]
  (if (= (count animals) 1)
    ""
    (let [pairs (make-pairs (reverse animals))
          lines (map (fn [x] (animals->swallowed-catched-line x)) pairs)]
      (str (string/join ",\n" lines) ";\n"))))

(def default-song (str (animal->swallowed-a-line (nth animals 0)) full-stop-new-line
                       (nth comments 0) double-new-line

                       (animal->swallowed-a-line (nth animals 1)) semi-colon-new-line
                       (nth comments 1) new-line
                       (animals->swallowed-catched-lines (take 2 animals))
                       (nth comments 0) double-new-line

                       (animal->swallowed-a-line (nth animals 2)) semi-colon-new-line
                       (nth comments 2) new-line
                       (animals->swallowed-catched-lines (take 3 animals))
                       (nth comments 0) double-new-line

                       (animal->swallowed-a-line (nth animals 3)) semi-colon-new-line
                       (nth comments 3) new-line
                       (animals->swallowed-catched-lines (take 4 animals))
                       (nth comments 0) double-new-line

                       (animal->swallowed-a-line (nth animals 4)) semi-colon-new-line
                       (nth comments 4) new-line
                       (animals->swallowed-catched-lines (take 5 animals))
                       (nth comments 0) double-new-line

                       (animal->swallowed-a-line (nth animals 5)) semi-colon-new-line
                       (nth comments 5) new-line
                       (animals->swallowed-catched-lines (take 6 animals))
                       (nth comments 0) double-new-line

                       (animal->swallowed-a-line (nth animals 6)) ellipsis-new-line
                       (nth comments 6) new-line))

(defn sing [& args]
  default-song)

(defn -main [& args]
  (pprint/pprint default-song))
