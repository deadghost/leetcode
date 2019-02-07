(ns leetcode.ex-013)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Roman to Integer
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Roman numerals are represented by seven different symbols: I, V, X, L, C, D
;; and M.
;; 
;; Symbol       Value
;; I             1
;; V             5
;; X             10
;; L             50
;; C             100
;; D             500
;; M             1000
;; 
;; For example, two is written as II in Roman numeral, just two one's added
;; together. Twelve is written as, XII, which is simply X + II. The number
;; twenty seven is written as XXVII, which is XX + V + II.
;; 
;; Roman numerals are usually written largest to smallest from left to right.
;; However, the numeral for four is not IIII. Instead, the number four is
;; written as IV. Because the one is before the five we subtract it making
;; four. The same principle applies to the number nine, which is written as IX.
;; There are six instances where subtraction is used:
;; 
;; I can be placed before V (5) and X (10) to make 4 and 9. 
;; X can be placed before L (50) and C (100) to make 40 and 90. 
;; C can be placed before D (500) and M (1000) to make 400 and 900.
;; 
;; Given a roman numeral, convert it to an integer. Input is guaranteed to be
;; within the range from 1 to 3999.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; Time complexity: O(n)
;;   The time to compute increases linearly with the roman numeral length.
;; Space complexity: O(1)
;;   The number of digits in the integer increases at a log10 rate. The result
;;   is an integer which takes up the same amount of space.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def roman-table
  {"M" 1000
   "CM" 900
   "D" 500
   "CD" 400
   "C" 100
   "XC" 90
   "L" 50
   "XL" 40
   "X" 10
   "IX" 9
   "V" 5
   "IV" 4
   "I" 1})

(defn roman->int
  ([s] (roman->int s 0))
  ([s accumulator]
   (let [char-0 (str (first s))
         char-01 (apply str (take 2 s))]
     (if (empty? s)
       accumulator
       (if-let [roman-value (get roman-table char-01)]
         ;; Two character roman numeral.
         (recur (apply str (drop 2 s))
                (+ accumulator roman-value))
         ;; One character roman numeral.
         (recur (apply str (drop 1 s))
                (+ accumulator (get roman-table char-0))))))))
