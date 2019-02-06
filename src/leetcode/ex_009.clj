(ns leetcode.ex-009)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Palindrome Number
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Determine whether an integer is a palindrome. An integer is a palindrome when
;; it reads the same backward as forward.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; Time complexity: O(log10(n))
;;   Each additional digit allows 10x the integer.
;; Space complexity: O(1)
;;   We only keep track of the integer and its reversal.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn palindrome-number?
  ([n] (palindrome-number? n 0))
  ([n accumulator]
   (cond (neg? n) false
         ;; Odd length check.
         (> accumulator n)
         (let [prev-acc (/ (- accumulator (mod accumulator 10)) 10)]
           (and (= prev-acc n)
                (not (zero? n))))
         ;; Even length check.
         (= n accumulator) true
         :else
         (let [last-digit (mod n 10)]
           (recur (/ (- n last-digit) 10)
                  (+ (* accumulator 10) last-digit))))))
