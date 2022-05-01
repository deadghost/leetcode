(ns leetcode.ex-021-test
  (:require
   [leetcode.ex-021 :as sut]
   [clojure.test :as t :refer [deftest is testing]]))

(deftest merge-sorted-lists
  (testing "Given example cases."
    (is (= '(1 1 2 3 4 4)
           (sut/merge-sorted-lists
            '(1 2 4)
            '(1 3 4))))
    (is (= '()
           (sut/merge-sorted-lists
            '()
            '())))
    (is (= '(0)
           (sut/merge-sorted-lists
            '()
            '(0))))))
