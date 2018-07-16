(ns song.core
  (:require [clojure.pprint :as pprint]
            [clojure.string :as string])
  (:gen-class))

(def line-separator "\n")

(defn animals->swallowed-catched-line [[animal-1 animal-2]]
  (str "She swallowed the " animal-1 " to catch the " animal-2))

(defn make-pairs [xs]
  (let [map-fn (fn [idx] [(nth xs idx) (nth xs (+ idx 1))])
        indexes (range (- (count xs) 1))]
    (map map-fn indexes)))

(defn animals->swallowed-catched-lines [animals]
  (let [pairs (make-pairs (reverse animals))
        lines (map (fn [x] (animals->swallowed-catched-line x)) pairs)]
    (str (string/join (str "," line-separator) lines) ";" line-separator)))

(defn animal->swallowed-a-line [animal]
  (str "There was an old lady who swallowed a " animal))

(defn song-data->verse [song-data]
  (str (animal->swallowed-a-line (:animal (last song-data)))
       ";"
       line-separator
       (:comment (last song-data))
       line-separator
       (animals->swallowed-catched-lines (map :animal song-data))
       (:comment (first song-data))))

(defn song-data-item->closing-verse [{:keys [animal comment]}]
  (str (animal->swallowed-a-line animal)
       "..."
       line-separator
       comment))

(defn song-data-item->opening-verse [{:keys [animal comment]}]
  (str (animal->swallowed-a-line animal)
       "."
       line-separator
       comment))

(defn middle-verse-accumulator [song-data acc idx]
  (into acc [(song-data->verse (take idx song-data))]))

(defn sing [song-data]
  (let [opening-verse (song-data-item->opening-verse (first song-data))
        closing-verse (song-data-item->closing-verse (last song-data))
        standard-verse-indexes (range 2 (count song-data))
        middle-verses (reduce (partial middle-verse-accumulator song-data) [] standard-verse-indexes)
        verses (into (into [opening-verse] middle-verses) [closing-verse])
        verse-separator (str line-separator line-separator)]
    (str (string/join verse-separator verses) line-separator)))

(defn -main [song-data]
  (pprint/pprint (sing song-data)))
