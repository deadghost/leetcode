(ns leetcode.ex-226-test
  (:require [leetcode.ex-226 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest invert-binary-tree
  (testing "Example."
    (is (= (sut/invert-binary-tree '(4 (2 (1) (3))
                                       (7 (6) (9))))
           [4
            [7 [9] [6]]
            [2 [3] [1]]])))
  (testing "Empty."
    (is (= (sut/invert-binary-tree '())
           []))))
