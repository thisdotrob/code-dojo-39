(ns song.core
  (:require [clojure.pprint :as pprint])
  (:gen-class))

(def animals ["fly" "spider" "bird" "cat" "dog" "cow" "horse"])

(def default-song (str "There was an old lady who swallowed a " (first animals) ".
I don't know why she swallowed a " (first animals) " - perhaps she'll die!

There was an old lady who swallowed a " (second animals) ";
That wriggled and wiggled and tickled inside her.
She swallowed the " (second animals) " to catch the fly;
I don't know why she swallowed a " (first animals) " - perhaps she'll die!

There was an old lady who swallowed a " (nth animals 2) ";
How absurd to swallow a " (nth animals 2) ".
She swallowed the " (nth animals 2) " to catch the " (second animals) ",
She swallowed the " (second animals) " to catch the " (first animals) ";
I don't know why she swallowed a " (first animals) " - perhaps she'll die!

There was an old lady who swallowed a " (nth animals 3) ";
Fancy that to swallow a " (nth animals 3) "!
She swallowed the " (nth animals 3) " to catch the " (nth animals 2) ",
She swallowed the " (nth animals 2) " to catch the " (second animals) ",
She swallowed the " (second animals) " to catch the " (first animals) ";
I don't know why she swallowed a " (first animals) " - perhaps she'll die!

There was an old lady who swallowed a " (nth animals 4) ";
What a hog, to swallow a " (nth animals 4) "!
She swallowed the " (nth animals 4) " to catch the " (nth animals 3) ",
She swallowed the " (nth animals 3) " to catch the " (nth animals 2) ",
She swallowed the " (nth animals 2) " to catch the " (second animals) ",
She swallowed the " (second animals) " to catch the " (first animals) ";
I don't know why she swallowed a " (first animals) " - perhaps she'll die!

There was an old lady who swallowed a " (nth animals 5) ";
I don't know how she swallowed a " (nth animals 5) "!
She swallowed the " (nth animals 5) " to catch the " (nth animals 4) ",
She swallowed the " (nth animals 4) " to catch the " (nth animals 3) ",
She swallowed the " (nth animals 3) " to catch the " (nth animals 2) ",
She swallowed the " (nth animals 2) " to catch the " (second animals) ",
She swallowed the " (second animals) " to catch the " (first animals) ";
I don't know why she swallowed a " (first animals) " - perhaps she'll die!

There was an old lady who swallowed a " (nth animals 6) "...
...She's dead, of course!
"))

(defn sing [& args]
  default-song)

(defn -main [& args]
  (pprint/pprint default-song))
