(ns leetcode.ex-014)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Longest Common Prefix
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Write a function to find the longest common prefix string amongst an array of
;; strings.
;; 
;; If there is no common prefix, return an empty string "".
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; Time complexity: O(log2(n))
;;   The solution space halves at every iteration.
;; Space complexity: O(1)
;;   The solution is a substring of all strings in the array.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn common-prefix
  "The solution is between common-min(inclusive) and common-max(exclusive).
  We inc common-max initially to include the last character in the possible
  solution space."
  ([xs] (common-prefix xs 0 (inc (apply min (map count xs)))))
  ([xs common-min common-max]
   (if (= common-min (dec common-max))
     ;; Longest prefix found.
     (apply str (take common-min (first xs)))
     ;; Proceed.
     (let [common-mid (quot (+ common-min common-max) 2)]
       (if (apply = (map #(take common-mid %) xs))
         ;; Longest prefix is at or after common-mid.
         (recur xs common-mid common-max)
         ;; Longest prefix is before common-mid.
         (recur xs common-min common-mid))))))
