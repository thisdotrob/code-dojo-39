(ns song.core-test
  (:require [clojure.test :refer :all]
            [song.core :as sut]))

(deftest make-pairs
  (testing "It returns a vec of pairs"
    (let [animals ["hog" "pig" "boar"]
          expected  [["hog" "pig"] ["pig" "boar"]]]
      (is (= expected (sut/make-pairs animals))))))

(deftest animals->swallowed-catched-lines
  (testing "It returns correct lines for two animals"
    (let [animals ["turtle" "dog"]
          expected (str "She swallowed the dog to catch the turtle;\n")]
      (is (= expected (sut/animals->swallowed-catched-lines animals)))))
  (testing "It returns correct lines for five animals"
    (let [animals ["turtle" "dog" "rabbit" "skunk" "wilderbeast"]
          expected (str "She swallowed the wilderbeast to catch the skunk,\n"
                        "She swallowed the skunk to catch the rabbit,\n"
                        "She swallowed the rabbit to catch the dog,\n"
                        "She swallowed the dog to catch the turtle;\n")]
      (is (= expected (sut/animals->swallowed-catched-lines animals))))))

(deftest song-data-item->closing-verse
  (testing "It returns an closing verse for the provided animal"
    (let [song-data {:animal "turtle" :comment "Something about a turtle!"}
          expected "There was an old lady who swallowed a turtle...\nSomething about a turtle!"]
      (is (= expected (sut/song-data-item->closing-verse song-data))))))

(deftest song-data-item->opening-verse
  (testing "It returns an opening verse for the provided animal"
    (let [song-data {:animal "turtle" :comment "Something about a turtle!"}
          expected "There was an old lady who swallowed a turtle.\nSomething about a turtle!"]
      (is (= expected (sut/song-data-item->opening-verse song-data))))))

(deftest song-data->verse
  (testing  "It returns a verse for two animals"
    (let [song-data [{:animal "turtle" :comment "Something about a turtle!"}
                     {:animal "dog" :comment "Line about the dog..."}]
          expected (str "There was an old lady who swallowed a dog;\n"
                        "Line about the dog...\n"
                        "She swallowed the dog to catch the turtle;\n"
                        "Something about a turtle!")]
      (is (= expected (sut/song-data->verse song-data)))))
  (testing "It returns a verse for three animals"
    (let [song-data [{:animal "turtle" :comment "Something about a turtle!"}
                     {:animal "dog" :comment  "It returns a verse for two animals"}
                     {:animal "penguin" :comment "Penguin related stuff-"}]
          expected (str "There was an old lady who swallowed a penguin;\n"
                        "Penguin related stuff-\n"
                        "She swallowed the penguin to catch the dog,\n"
                        "She swallowed the dog to catch the turtle;\n"
                        "Something about a turtle!")]
      (is (= expected (sut/song-data->verse song-data))))))

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
  (testing "It returns the song as a string for 3 animals"
    (let [song-data [{:animal "fly" :comment "I don't know why she swallowed a fly - perhaps she'll die!"}
                     {:animal "spider" :comment "That wriggled and wiggled and tickled inside her."}
                     {:animal "bird" :comment "How absurd to swallow a bird."}]
          expected (slurp "test/song/fixtures/3-animal-song.txt")]
      (is (= expected (sut/sing song-data)))))
  (testing "It returns the song as a string for 7 animals"
    (let [song-data [{:animal "fly" :comment "I don't know why she swallowed a fly - perhaps she'll die!"}
                     {:animal "spider" :comment "That wriggled and wiggled and tickled inside her."}
                     {:animal "bird" :comment "How absurd to swallow a bird."}
                     {:animal "cat" :comment "Fancy that to swallow a cat!"}
                     {:animal "dog" :comment "What a hog, to swallow a dog!"}
                     {:animal "cow" :comment "I don't know how she swallowed a cow!"}
                     {:animal "horse":comment "...She's dead, of course!"}]
          expected (slurp "test/song/fixtures/song.txt")]
      (is (= expected (sut/sing song-data))))))
