(ns leetcode.ex-704-test
  (:require
   [leetcode.ex-704 :as sut]
   [clojure.test :as t :refer [deftest is testing]]))

(deftest binary-search
  (testing "Given examples."
    (is (= 4 (sut/binary-search [-1 0 3 5 9 12] 9)))
    (is (= -1 (sut/binary-search [-1 0 3 5 9 12] 2)))))
