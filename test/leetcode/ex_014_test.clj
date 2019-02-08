(ns leetcode.ex-014-test
  (:require [leetcode.ex-014 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest common-prefix
  (testing "Examples."
    (is (= (sut/common-prefix ["flower" "flow" "flight"]) "fl"))
    (is (= (sut/common-prefix ["dog" "racecar" "car"]) "")))
  (testing "More examples."
    (is (= (sut/common-prefix ["banana" "banyan" "banyak"]) "ban"))
    (is (= (sut/common-prefix ["ho" "ho" "ho"]) "ho"))
    (is (= (sut/common-prefix ["ye" "yea" "yeap" "yeapie"]) "ye"))
    (is (= (sut/common-prefix ["" ""]) ""))))
