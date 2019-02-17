(ns leetcode.ex-015-test
  (:require [leetcode.ex-015 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest three-sum
  (testing "Examples."
    (is (= (sut/three-sum [-1 0 1 2 -1 -4]) #{[-1 0 1] [-1 -1 2]})))
  (testing "More examples."
    (is (= (sut/three-sum [0 0 -2 0 1 1]) #{[0 0 0] [-2 1 1]}))))
