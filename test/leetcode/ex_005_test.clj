(ns leetcode.ex-005-test
  (:require [leetcode.ex-005 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest longest-palindromic-substr
  (testing "Examples."
    (is (let [substr (sut/longest-palindromic-substr "babad")]
          (or (= substr "bab")
              (= substr "aba"))))
    (is (= (sut/longest-palindromic-substr "cbbd") "bb")))
  (testing "More examples."
    (is (= (sut/longest-palindromic-substr "abagefegadfa") "agefega"))))
