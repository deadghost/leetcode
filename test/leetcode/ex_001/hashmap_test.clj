(ns leetcode.ex-001.brute-force-test
  (:require [leetcode.ex-001.hashmap :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest two-sum-test
  (testing "Example."
    (is (= (sut/two-sum [2 7 11 15] 9)
           [0 1])))
  (testing "Two equal integers in different indices."
    (is (= (sut/two-sum [2 7 11 7 15] 14)
           [1 3]))))
