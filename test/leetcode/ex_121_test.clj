(ns leetcode.ex-121-test
  (:require
   [leetcode.ex-121 :as sut]
   [clojure.test :as t :refer [deftest is testing]]))

(deftest max-profit
  (testing "Given scenarios."
    (is (= 5 (sut/max-profit [7 1 5 3 6 4])))
    (is (= 0 (sut/max-profit [7 6 4 3 1])))))
