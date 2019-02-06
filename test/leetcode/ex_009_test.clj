(ns leetcode.ex-009-test
  (:require [leetcode.ex-009 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest palindrome-number?
  (testing "Examples."
    (is (sut/palindrome-number? 121))
    (is (not (sut/palindrome-number? -121)))
    (is (not (sut/palindrome-number? 10))))
  (testing "More tests."
    (is (sut/palindrome-number? 1221))
    (is (not (sut/palindrome-number? -1221)))
    (is (not (sut/palindrome-number? 123)))
    (is (sut/palindrome-number? 101))))
