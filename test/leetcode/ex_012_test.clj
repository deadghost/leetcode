(ns leetcode.ex-012-test
  (:require [leetcode.ex-012 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest n->roman
  (testing "Examples."
    (is (= (sut/n->roman 3) "III"))
    (is (= (sut/n->roman 4) "IV"))
    (is (= (sut/n->roman 9) "IX"))
    (is (= (sut/n->roman 58) "LVIII"))
    (is (= (sut/n->roman 1994) "MCMXCIV"))))
