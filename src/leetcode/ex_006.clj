(ns leetcode.ex-006)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; ZigZag Conversion
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; The string "PAYPALISHIRING" is written in a zigzag pattern on a given
;; number of rows like this: (you may want to display this pattern in a fixed
;; font for better legibility)
;; 
;; P   A   H   N
;; A P L S I I G
;; Y   I   R
;; 
;; And then read line by line: "PAHNAPLSIIGYIR"
;; 
;; Write the code that will take a string and make this conversion given a
;; number of rows:
;; 
;; string convert(string s, int numRows)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; We break this problem into up and down cycles. We start in the down cycle
;; until we reach the row-count then go into the up cycle until we hit the first
;; row. We repeat until the string is exhausted.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; Time complexity: O(n)
;;   The time scales linearly with the string length as we need to traverse
;;   the entire length before we can compute the result.
;; Space complexity: O(n)
;;   The solution length is 1:1 with the string input length.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn zigzag
  ([s row-count]
   (zigzag s row-count 0 inc (into [] (take row-count (repeat [])))))
  ([s row-count current-row cycle-fn accumulator]
   (cond (empty? s)
         (apply str (apply concat accumulator))
         ;; Start dec cycle.
         (= current-row (dec row-count))
         (recur (drop 1 s) row-count (dec current-row) dec
                (update accumulator current-row conj (first s)))
         ;; Start inc cycle.
         (= current-row 0)
         (recur (drop 1 s) row-count (inc current-row) inc
                (update accumulator current-row conj (first s)))
         ;; Continue current cycle.
         :else
         (recur (drop 1 s) row-count (cycle-fn current-row) cycle-fn
                (update accumulator current-row conj (first s))))))
