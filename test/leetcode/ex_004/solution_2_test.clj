(ns leetcode.ex-004-test.solution-2-test
  (:require [leetcode.ex-004.solution-2 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest median-sorted-seq
  (testing "Examples"
    (is (= (sut/median-sorted-seq [1 3] [2])
           2))
    (is (= (sut/median-sorted-seq [1 2] [3 4])
           2.5)))
  (testing "Other Tests."
    (is (= (sut/median-sorted-seq [1 3 8 12] [2 8])
           5.5))
    (is (== (sut/median-sorted-seq [-1 -3 8 12] [2 8])
            5)))) 
