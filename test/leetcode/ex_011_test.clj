(ns leetcode.ex-011-test
  (:require [leetcode.ex-011 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest water-bars
  (testing "Example."
    (is (= (sut/water-bars [1 8 6 2 5 4 8 3 7]) 49)))
  (testing "More examples."
    (is (= (sut/water-bars [1 1]) 1))
    (is (= (sut/water-bars [10 1 5]) 10))))
