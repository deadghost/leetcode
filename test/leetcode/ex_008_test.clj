(ns leetcode.ex-008-test
  (:require [leetcode.ex-008 :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest atoi
  (testing "Examples."
    (is (= (sut/atoi "42") 42))
    (is (= (sut/atoi "   -42") -42))
    (is (= (sut/atoi "4193 with words") 4193))
    (is (= (sut/atoi "words and 987") 0))
    ;; The number "-91283472332" is out of the range of a 32-bit signed integer.
    ;; Therefore INT_MIN (−2^31) is returned.
    ;; I think this is kind of dumb but ok.
    (is (= (sut/atoi "-91283472332") -2147483648))))
