(ns leetcode.ex-242)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Valid Anagram
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Given two strings s and t, return true if t is an anagram of s, and false
;; otherwise.
;; 
;; An Anagram is a word or phrase formed by rearranging the letters of a
;; different word or phrase, typically using all the original letters exactly
;; once.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Approach
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Option 1: Sort and check equality.
;; Option 2: Count letters and check letter count equality.
;;
;; Optimizations
;; - Do an initial length check
;;
;; We'll go with Option 2 here as it is a single pass through each string an
;; should be less work than sorting.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn count-chars [s]
  (reduce (fn [acc char]
            (if (get acc char)
              (update acc char inc)
              (assoc acc char 1)))
          {}
          s))

(defn anagram?
  [s1 s2]
  (= (count-chars s1)
     (count-chars s2)))
