(ns leetcode.ex-003-test
  (:require [leetcode.ex-003 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest longest-wo-repeating-chars
  (testing "Examples."
    (is (= (sut/longest-wo-repeating-chars "abcabcbb") 3))
    (is (= (sut/longest-wo-repeating-chars "bbbbb") 1))
    (is (= (sut/longest-wo-repeating-chars "pwwkew") 3))))
