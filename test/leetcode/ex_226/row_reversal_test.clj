(ns leetcode.ex-226.row-reversal-test
  (:require
   [leetcode.ex-226.row-reversal :as sut]
   [clojure.test :as t :refer [deftest is testing]]))

(deftest invert-binary-tree
  (testing "Given examples."
    (is (= [4 7 2 9 6 3 1]
           (sut/invert-binary-tree [4 2 7 1 3 6 9])))
    (is (= [2 3 1]
           (sut/invert-binary-tree [2 1 3])))))
