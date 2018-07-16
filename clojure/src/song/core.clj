(ns song.core
  (:require [clojure.pprint :as pprint]
            [clojure.string :as string])
  (:gen-class))

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
  (let [pairs (make-pairs (reverse animals))
        lines (map (fn [x] (animals->swallowed-catched-line x)) pairs)]
    (str (string/join ",\n" lines) ";\n")))

(defn animal-&-comment->opening-verse [animal comment]
  (str (animal->swallowed-a-line animal)
       full-stop-new-line
       comment
       double-new-line))

(defn animals-&-comments->verse [animals comments]
  (str (animal->swallowed-a-line (last animals))
       semi-colon-new-line
       (last comments)
       new-line
       (animals->swallowed-catched-lines animals)
       (first comments)
       double-new-line))

(defn animal-&-comment->closing-verse [animal comment]
  (str (animal->swallowed-a-line animal) ellipsis-new-line comment new-line))

(defn sing [animals comments]
  (let [opening-verse (animal-&-comment->opening-verse (first animals) (first comments))
        closing-verse (animal-&-comment->closing-verse (last animals) (last comments))
        standard-verse-indexes (range 2 (count animals))
        middle-verse-accumulator (fn [a x] (str a (animals-&-comments->verse (take x animals) (take x comments))))
        middle-verses (reduce middle-verse-accumulator "" standard-verse-indexes)]
    (str opening-verse middle-verses closing-verse)))

(defn -main [animals comments]
  (pprint/pprint (sing animals comments)))
