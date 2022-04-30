(ns leetcode.ex-020-test
  (:require
   [leetcode.ex-020 :as sut]
   [clojure.test :as t :refer [deftest are testing]]))

(deftest valid-parens?
  (testing "Paren truth table."
    (are [s bool] (= bool (sut/valid-parens? s))
      "()" true
      "[]" true
      "{}" true
      "(]" false
      "[}" false
      "{)" false
      "(+ 1 1)" true
      "(+ 1" false
      "[1 2 3]" true
      "[1 2 3" false
      "{:key 123}" true
      "{:key 123" false
      "(apply + [1 2 3])" true
      "(apply + [1 2 3)" false
      "(select-keys {:foo :bar} [:foo])" true
      "(select-keys {:foo :bar} :foo])" false)))
