(ns song.core-test
  (:require [clojure.test :refer :all]
            [song.core :as sut]))

(deftest animals->swallowed-catched-line
  (testing "It returns a swallowed ... to catch ... line"
    (let [animals ["cat" "dog"]
          expected "She swallowed the cat to catch the dog"]
      (is (= expected (sut/animals->swallowed-catched-line animals))))))

(deftest animal->swallowed-a-line
  (testing "It returns the swallowed a ... line"
    (let [animal "badger"
          expected "There was an old lady who swallowed a badger"]
      (is (= expected (sut/animal->swallowed-a-line animal))))))

(deftest sing
  (testing "It returns the song as a string"
    (let [expected (slurp "test/song/fixtures/song.txt")]
      (is (= expected (sut/sing))))))
