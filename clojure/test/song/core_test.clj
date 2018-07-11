(ns song.core-test
  (:require [clojure.test :refer :all]
            [song.core :as sut]))

(deftest sing
  (testing "It returns the song as a string"
    (let [expected (slurp "test/song/fixtures/song.txt")]
      (is (= expected (sut/sing))))))
