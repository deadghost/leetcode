(ns leetcode.ex-013-test
  (:require [leetcode.ex-013 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest roman->int
  (testing "Examples."
    (is (= (sut/roman->int "III") 3))
    (is (= (sut/roman->int "IV") 4))
    (is (= (sut/roman->int "IX") 9))
    (is (= (sut/roman->int "LVIII") 58))
    (is (= (sut/roman->int "MCMXCIV") 1994))))
