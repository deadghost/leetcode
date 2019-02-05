(ns leetcode.ex-007-test
  (:require [leetcode.ex-007 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest reverse-int
  (testing "Examples."
    (is (= (sut/reverse-int 123) 321))
    (is (= (sut/reverse-int -123) -321))
    (is (= (sut/reverse-int 120) 21))))
