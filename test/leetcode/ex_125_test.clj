(ns leetcode.ex-125-test
  (:require
   [leetcode.ex-125 :as sut]
   [clojure.test :as t :refer [deftest is testing]]))

(deftest palindrome?
  (testing "Given examples."
    (is (true? (sut/palindrome? "A man, a plan, a canal: Panama")))
    (is (false? (sut/palindrome? "race a car")))
    (is (true? (sut/palindrome? " ")))))
