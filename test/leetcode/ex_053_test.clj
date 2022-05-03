(ns leetcode.ex-053-test
  (:require
   [leetcode.ex-053 :as sut]
   [clojure.test :as t :refer [deftest testing is]]))

(deftest max-subarray
  (testing "Given examples."
    (is (= 6
           (sut/max-subarray [-2 1 -3 4 -1 2 1 -5 4])))
    (is (= 1 (sut/max-subarray [1])))
    (is (= 23 (sut/max-subarray [5 4 -1 7 8])))))
