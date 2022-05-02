(ns leetcode.ex-242-test
  (:require
   [leetcode.ex-242 :as sut]
   [clojure.test :as t :refer [deftest is testing]]))

(deftest anagram?
  (testing "Given examples."
    (is (true? (sut/anagram? "anagram" "nagaram")))
    (is (false? (sut/anagram? "rat" "car")))))
