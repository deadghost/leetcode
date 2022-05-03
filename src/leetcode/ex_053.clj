(ns leetcode.ex-053)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Maximum Subarray
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Given an integer array nums, find the contiguous subarray (containing at
;; least one number) which has the largest sum and return its sum.
;;
;; A subarray is a contiguous part of an array.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; See: https://en.wikipedia.org/wiki/Maximum_subarray_problem

(defn max-subarray
  [nums]
  (loop [left-index 0
         right-index 0
         current-sum 0
         largest-sum 0]
    (let [left-val (get nums left-index)]
      (cond
        ;; We're at the end, return the result
        (>= right-index (count nums))
        largest-sum

        ;; move left index forward
        (neg? left-val)
        (let [new-sum (- current-sum left-val)]
          (recur
           (inc left-index)
           right-index
           new-sum
           (if (> new-sum largest-sum)
             new-sum
             largest-sum)))

        ;; left-val is positive
        :else
        (let [right-val (get nums right-index)
              new-sum (+ current-sum right-val)]
          (if (<= new-sum 0)
            ;; case where right-val brings sum below 0
            (recur
             (inc right-index)
             (inc right-index)
             0
             largest-sum)

            ;; Move right index forward
            (recur
             left-index
             (inc right-index)
             new-sum
             (if (> new-sum largest-sum)
               new-sum
               largest-sum))))))))
