(ns leetcode.ex-733-test
  (:require
   [leetcode.ex-733 :as sut]
   [clojure.test :as t :refer [deftest is testing]]))

(deftest flood-fill
  (testing "Given examples."
    (is (= [[2 2 2] [2 2 0] [2 0 1]]
           (sut/flood-fill {:grid [[1 1 1]
                                   [1 1 0]
                                   [1 0 1]]
                            :starting-row-index 1
                            :starting-col-index 1
                            :new-color 2})))
    (is (= [[2 2 2] [2 2 2]]
           (sut/flood-fill {:grid [[0 0 0]
                                   [0 0 0]]
                            :starting-row-index 0
                            :starting-col-index 0
                            :new-color 2})))))
