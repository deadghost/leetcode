(ns leetcode.ex-004-test.solution-1-test
  (:require [leetcode.ex-004.solution-1 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest median-sorted-seq
  (testing "Examples"
    (is (= (sut/median-sorted-seq [1 3] [2])
           2))
    (is (= (sut/median-sorted-seq [1 2] [3 4])
           2.5)))) 
