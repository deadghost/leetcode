(ns leetcode.ex-015
  (:require [leetcode.ex-001.hashmap :refer [xs->m]]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 3Sum
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Given an array nums of n integers, are there elements a, b, c in nums such
;; that a + b + c = 0? Find all unique triplets in the array which gives the
;; sum of zero.
;; 
;; Note: The solution set must not contain duplicate triplets.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; The problem can be reduced to a 2Sum problem where a + b = -c.
;; This problem differs from ex1 2Sum in that it asks for all unique triplets,
;; meaning a target sum can have more than one a + b combination.
;; The sum target also has an index that must be excluded from possible a + b
;; combinations.

(defn three-sum?
  "The sum value has already been inverted. The sum value must be inverted
  again before we look it up in the hashmap. Returns x, y, and sum-v."
  [m x sum-v]
  (let [y (- sum-v x)]
    (cond (and (zero? x) (zero? sum-v)) ; x, y, sum are all 0 and thus equal
          (when (>= (count (get m 0)) 3) ; Three 0s must be available
            [0 0 0])
          (= x y) ; same x and y
          (when (>= (count (get m x)) 2) ; Two x/y values must be available
            [x y sum-v])
          ;; Ex. 2 + -4 = -2
          (or (= x (* -1 sum-v))
              (= y (* -1 sum-v)))
          ;; Two -sum-v must be available.
          (when (>= (count (get m (* -1 sum-v))) 2)
            [x y sum-v])
          :else ; Standard case where x, y, and sum are all unique.
          (when (get m y)
            [x y sum-v]))))

(defn two-sum
  "Given an array of integers, return all indices of the two numbers such that
  they add up to a specific target."
  [xs sum]
  (let [m (xs->m xs)]
    (keep #(three-sum? m % sum) xs)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; Time complexity: O(n^2)
;;   We break our problem into a 2sum problem(ex1) using a hashmap. A 2sum
;;   problem using a hashmap is O(n) for a single sum target. We have n sum
;;   targets in a 3sum so it is O(n^2).
;; Space complexity: O(n)
;;   The number of solutions grow linearly with the array size.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn three-sum [xs]
  (let [m (xs->m xs)]
    (->> (map #(two-sum xs (* -1 %)) xs) ; invert the target sum
         ;; data cleaning
         (apply concat)
         ;; The sum had been previously inverted and we need to uninvert it.
         (map #(conj (drop-last %) (* -1 (last %))))
         ;; We sort into a set to remove duplicate triplets.
         (map #(sort < %))
         (into #{}))))
