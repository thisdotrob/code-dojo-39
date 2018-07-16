(ns song.core-test
  (:require [clojure.test :refer :all]
            [song.core :as sut]))

(deftest make-pairs
  (testing "It returns a vec of pairs"
    (let [animals ["hog" "pig" "boar"]
          expected  [["hog" "pig"] ["pig" "boar"]]]
      (is (= expected (sut/make-pairs animals))))))

(deftest animals->swallowed-catched-lines
  (testing "It returns an empty string for a single animal"
    (let [animals ["turtle"]
          expected ""]
      (is (= expected (sut/animals->swallowed-catched-lines animals)))))
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

(deftest animal-&-comment->closing-verse
  (testing "It returns an closing verse for the provided animal"
    (let [animal "turtle"
          comment "Something about a turtle!"
          expected "There was an old lady who swallowed a turtle...\nSomething about a turtle!\n"]
      (is (= expected (sut/animal-&-comment->closing-verse animal comment))))))

(deftest animal-&-comment->opening-verse
  (testing "It returns an opening verse for the provided animal"
    (let [animal "turtle"
          comment "Something about a turtle!"
          expected "There was an old lady who swallowed a turtle.\nSomething about a turtle!\n\n"]
      (is (= expected (sut/animal-&-comment->opening-verse animal comment))))))

(deftest animals-&-comments->verse
  (testing "It returns a verse for two animals"
    (let [animals ["turtle" "dog"]
          comments ["Something about a turtle!" "Line about the dog..."]
          expected (str "There was an old lady who swallowed a dog;\n"
                        "Line about the dog...\n"
                        "She swallowed the dog to catch the turtle;\n"
                        "Something about a turtle!\n\n")]
      (is (= expected (sut/animals-&-comments->verse animals comments)))))
  (testing "It returns a verse for three animals"
    (let [animals ["turtle" "dog" "penguin"]
          comments ["Something about a turtle!" "Line about the dog..." "Penguin related stuff-"]
          expected (str "There was an old lady who swallowed a penguin;\n"
                        "Penguin related stuff-\n"
                        "She swallowed the penguin to catch the dog,\n"
                        "She swallowed the dog to catch the turtle;\n"
                        "Something about a turtle!\n\n")]
      (is (= expected (sut/animals-&-comments->verse animals comments))))))

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
    (let [animals ["fly" "spider" "bird"]
          comments ["I don't know why she swallowed a fly - perhaps she'll die!"
                    "That wriggled and wiggled and tickled inside her."
                    "How absurd to swallow a bird."]
          expected (slurp "test/song/fixtures/3-animal-song.txt")]
      (is (= expected (sut/sing animals comments)))))
  (testing "It returns the song as a string for 7 animals"
    (let [animals ["fly" "spider" "bird" "cat" "dog" "cow" "horse"]
          comments ["I don't know why she swallowed a fly - perhaps she'll die!"
                    "That wriggled and wiggled and tickled inside her."
                    "How absurd to swallow a bird."
                    "Fancy that to swallow a cat!"
                    "What a hog, to swallow a dog!"
                    "I don't know how she swallowed a cow!"
                    "...She's dead, of course!"]
          expected (slurp "test/song/fixtures/song.txt")]
      (is (= expected (sut/sing animals comments))))))
