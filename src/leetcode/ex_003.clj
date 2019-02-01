(ns leetcode.ex-003
  (:require [leetcode.util :refer [maplist]]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Longest Substring Without Repeating Characters
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Given a string, find the length of the longest substring without repeating
;; characters.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn str-until-dup
  "Returns length of substring until a duplicate character is encountered."
  ([s] (str-until-dup s #{}))
  ([s accumulator]
   (if (or (get accumulator (first s))
           (empty? s))
     (count accumulator)
     (recur (rest s) (conj accumulator (first s))))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; Time complexity: O(n^2)
;;   For every character, we search through the rest of the string for
;;   duplicates.
;; Space complexity: O(n)
;;   Substring counts is 1:1 with string length. We accumulate a list of these
;;   counts before applying `max`.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn longest-wo-repeating-chars
  "Length of longest substring without duplicate characters."
  [s]
  (apply max (maplist str-until-dup s)))
