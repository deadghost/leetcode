(ns leetcode.ex-004.solution-2
  (:require [clojure.math.numeric-tower :refer [floor]]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Median of Two Sorted Arrays
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; There are two sorted arrays nums1 and nums2 of size m and n respectively.
;; 
;; Find the median of the two sorted arrays. The overall run time complexity
;; should be O(log (m+n)).
;; 
;; You may assume nums1 and nums2 cannot be both empty.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; Time complexity: O(log(min(m,n)))
;;   We split seq1 into left and right before index i. We do the same with seq2
;;   at index j. j can be defined in terms of i because i + j + 1 is equal to
;;   the index of the median number if the two sequences were merged. We are
;;   looking for the point where the max of the left <= the min of the right.
;;   We reduce our min/max i bounds by half every iteration by choosing the
;;   midpoint of the min and max i bounds. The decision to increase the min-i
;;   or decrease the max-i is based on which sequence on the left contains the
;;   largest number.
;; Space complexity: O(1)
;;   We're only storing a few values that do not increase in length.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn median-sorted-seq
  "We take sequences which is probably close enough to an array. i is the
  number of elements to take from xs1 and j is the number of elements to take
  from xs2."
  ([xs1 xs2]
   (let [[smaller-seq bigger-seq]
         (if (< (count xs1) (count xs2))
           [xs1 xs2]
           [xs2 xs1])]
     ;; Smaller seq first should be a bit faster.
     (median-sorted-seq smaller-seq bigger-seq 0 (count smaller-seq))))
  ([xs1 xs2 min-i max-i]
   (let [i (floor (/ (+ min-i max-i) 2))
         j (- (floor (/ (+ (count xs1) (count xs2)) 2)) i)
         [xs1-left xs1-right] (split-at i xs1)
         [xs2-left xs2-right] (split-at j xs2)
         left-max (max (or (last xs1-left) (last xs2-left)) ; Account for nils
                       (or (last xs2-left) (last xs1-left)))
         right-min (min (or (first xs1-right) (first xs2-right))
                        (or (first xs2-right) (first xs1-right)))]
     (cond (<= left-max right-min) ; Solution found
           (if (even? (+ (count xs1) (count xs2)))
             ;; Average the two middle numbers.
             (/ (+ left-max right-min) 2.0)
             ;; Return middle number.
             (if (< (+ (count xs1-left) (count xs2-left))
                    (+ (count xs1-right) (count xs2-right)))
               right-min
               left-max))
           (> (last xs1-left) (first xs2-right))
           (recur xs1 xs2 min-i (dec i))
           (> (last xs2-left) (first xs1-right))
           (recur xs1 xs2 (inc i) max-i)))))
