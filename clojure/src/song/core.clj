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

(def default-song (str (animal-&-comment->opening-verse (first animals) (first comments))
                       (animals-&-comments->verse (take 2 animals) (take 2 comments))
                       (animals-&-comments->verse (take 3 animals) (take 3 comments))
                       (animals-&-comments->verse (take 4 animals) (take 4 comments))
                       (animals-&-comments->verse (take 5 animals) (take 5 comments))
                       (animals-&-comments->verse (take 6 animals) (take 6 comments))
                       (animal->swallowed-a-line (nth animals 6)) ellipsis-new-line
                       (nth comments 6) new-line))

(defn sing [& args]
  default-song)

(defn -main [& args]
  (pprint/pprint default-song))
