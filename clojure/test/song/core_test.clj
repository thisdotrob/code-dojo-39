(ns song.core-test
  (:require [clojure.test :refer :all]
            [song.core :as sut]))

(deftest animals->swallowed-catched-line
  (testing "It returns a swallowed ... to catch ... line"
    (let [animals ["cat" "dog"]
          expected "She swallowed the cat to catch the dog"]
      (is (= expected (sut/animals->swallowed-catched-line animals))))))

(deftest sing
  (testing "It returns the song as a string"
    (let [expected (slurp "test/song/fixtures/song.txt")]
      (is (= expected (sut/sing))))))
