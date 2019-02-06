(ns leetcode.ex-010-test
  (:require [leetcode.ex-010 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest regex
  (testing "Examples."
    (is (not (sut/regex "aa" "a")))
    (is (sut/regex "aa" "a*"))
    (is (sut/regex "ab" ".*"))
    (is (sut/regex "aab" "c*a*b"))
    (is (not (sut/regex "mississippi" "mis*is*p*.")))))
