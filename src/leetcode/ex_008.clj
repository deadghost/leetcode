(ns leetcode.ex-008)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; String to Integer (atoi)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Implement atoi which converts a string to an integer.
;; 
;; The function first discards as many whitespace characters as necessary
;; until the first non-whitespace character is found. Then, starting from this
;; character, takes an optional initial plus or minus sign followed by as many
;; numerical digits as possible, and interprets them as a numerical value.
;; 
;; The string can contain additional characters after those that form the
;; integral number, which are ignored and have no effect on the behavior of
;; this function.
;; 
;; If the first sequence of non-whitespace characters in str is not a valid
;; integral number, or if no such sequence exists because either str is empty
;; or it contains only whitespace characters, no conversion is performed.
;; 
;; If no valid conversion could be performed, a zero value is returned.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; Time complexity: O(n)
;;   We need to read every character in the string.
;; Space complexity: O(1)
;;   The biggest possible result is 2^31.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn atoi
  ([s] (atoi s nil 0))
  ([s sign accumulator]
   (cond (or (empty? s)
             ;; Use only the first integer found.
             (and (get #{\space \+ \-} (first s))
                  (not (zero? accumulator)))
             ;; Hard return when encountering non-digits/spaces/+/-
             (not (get #{\1 \2 \3 \4 \5 \6 \7 \8 \9 \0 \space \+ \-}
                       (first s))))
         accumulator
         ;; Whitespace
         (= (first s) \space)
         (recur (drop 1 s) sign accumulator)
         ;; Set sign
         (= (first s) \-)
         (recur (drop 1 s) "-" accumulator)
         ;; Negative overflow
         (or (< accumulator -214748364)
             (< (- accumulator -214748364 (Character/digit (first s) 10))
                -8))
         -2147483648
         ;; Positive overflow
         (or (> accumulator 214748364)
             (> (- accumulator 214748364 (Character/digit (first s) 10))
                7))
         2147483647
         ;; - Int
         (= sign "-")
         (recur (drop 1 s)
                sign
                (- (* accumulator 10)
                   (Character/digit (first s) 10)))
         ;; + Int
         :else
         (recur (drop 1 s)
                sign
                (+ (* accumulator 10)
                   (Character/digit (first s) 10))))))
