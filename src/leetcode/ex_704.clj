(ns leetcode.ex-704)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Binary Search
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Given an array of integers nums which is sorted in ascending order, and an
;; integer target, write a function to search target in nums. If target exists,
;; then return its index. Otherwise, return -1.
;; 
;; You must write an algorithm with O(log n) runtime complexity.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn binary-search
  [nums target]
  (loop [left-index 0
         right-index (dec (count nums))]
    (let [center-index (quot (+ left-index right-index) 2)
          center-value (get nums center-index)]
      (cond
        ;; Not found
        (> left-index right-index)
        -1

        ;; Found
        (= target center-value)
        center-index

        ;; Search the left side
        (< target center-value)
        (recur 0 (dec center-index))

        ;; Search the right side
        (> target center-value)
        (recur (inc center-index) right-index)))))
