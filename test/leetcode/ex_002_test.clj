(ns leetcode.ex-002-test
  (:require [leetcode.ex-002 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest add-two-numbers
  (testing "Example."
    (is (= (sut/add-two-numbers '(2 4 3) '(5 6 4))
           '(7 0 8))))
  (testing "Uneven lists."
    (is (= (sut/add-two-numbers '(2 4 3 5) '(5 6 4))
           '(7 0 8 5)))
    (is (= (sut/add-two-numbers '(2 4 3) '(5 6 4 6))
           '(7 0 8 6))))
  (testing "0 sum."
    (is (= (sut/add-two-numbers '(0) '(0))
           '(0)))
    (is (= (sut/add-two-numbers '(0) '(1 2 3))
           '(1 2 3)))
    (is (= (sut/add-two-numbers '(4 5 6) '(0))
           '(4 5 6)))))
