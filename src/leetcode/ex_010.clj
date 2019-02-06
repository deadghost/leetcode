(ns leetcode.ex-010)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Regular Expression Matching
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Given an input string (s) and a pattern (p), implement regular expression
;; matching with support for '.' and '*'.
;; 
;; '.' Matches any single character.
;; '*' Matches zero or more of the preceding element.
;; 
;; The matching should cover the entire input string (not partial).
;;
;; Note:
;; 
;; s could be empty and contains only lowercase letters a-z.
;; p could be empty and contains only lowercase letters a-z, and characters
;; like . or *.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; Time complexity: O(n)
;;   We need to traverse all of s.
;; Space complexity: O(1)
;;   We reduce s and p as we compute and only return a boolean.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn regex [s p]
  (let [p0 (first p)
        p1 (second p)]
    (cond
      (or
       ;; Exhausted string and pattern.
       (and (empty? s) (empty? p))
       ;; Zero or more of any character.
       (and (= p0 \.)
            (= p1 \*)))
      true
      ;; Match zero or more or preceding character.
      (= p1 \*)
      (recur (drop-while #(= % p0) s) (drop 2 p))
      ;; Match any character.
      (and (= p0 \.)
           (first s))
      (recur (rest s) (rest p))
      ;; Char match.
      (= (first s) p0)
      (recur (rest s) (rest p))
      ;; Char not matched.
      :else false)))
