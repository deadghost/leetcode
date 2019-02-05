(ns leetcode.ex-007)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Reverse Integer
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Given a 32-bit signed integer, reverse digits of an integer.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; Time complexity: O(log(n))
;;   Each additional digit allows us to calculate 10x as many integers as the
;;   previous digit.
;; Space complexity: O(1)
;;   We only need to keep track of n and the reverse of n.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn abs
  "Absolute value of n. Can be found in numeric-tower lib."
  [n]
  (if (< n 0)
    (+ (* n -2) n)
    n))

(defn reverse-int
  ([n] (reverse-int n 0))
  ([n accumulator]
   (let [first-d (mod (abs n) 10)]
     (cond (zero? n)
           accumulator
           (pos? n)
           (recur (/ (- n first-d) 10)
                  (+ (* accumulator 10) first-d))
           :else ; neg n
           (recur (/ (+ n first-d) 10)
                  (- (* accumulator 10) first-d))))))
