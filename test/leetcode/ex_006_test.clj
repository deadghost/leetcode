(ns leetcode.ex-006-test
  (:require [leetcode.ex-006 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest zigzag
  (testing "Example."
    (is (= (sut/zigzag "PAYPALISHIRING" 3)
           "PAHNAPLSIIGYIR"))
    (is (= (sut/zigzag "PAYPALISHIRING" 4)
           "PINALSIGYAHRPI"))))
