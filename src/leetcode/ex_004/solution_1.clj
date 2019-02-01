(ns leetcode.ex-004.solution-1)

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

;; Clojure supports the creation, reading and modification of Java arrays. It is
;; recommended that you limit use of arrays to interop with Java libraries that
;; require them as arguments or use them as return values.
;; - https://clojure.org/reference/java_interop#_arrays

(defn take-until-other
  "Takes from the sorted seq with the lower value first element while the
  elements of the lower value seq is <= the first value of the second seq.
  Returns xs1, xs2, and take-xs where the seq with the lower value has take-xs
  dropped."
  [xs1 xs2]
  (cond
    ;; Both sequences are empty.
    (and (empty? xs1) (empty? xs2)) [xs1 xs2 []]
    ;; Empty xs1, return xs2 as take-xs.
    (empty? xs1)
    [[] [] xs2]
    ;; Empty xs2, return xs1 as take-xs.
    (empty? xs2)
    [[] [] xs1]
    ;; Take from xs1.
    (<= (or (first xs1)) (first xs2))
    (let [take-xs (take-while #(<= % (first xs2)) xs1)
          drop-xs1 (drop (count take-xs) xs1)]
      [drop-xs1 xs2 take-xs])
    :else ;; Take from xs2
    (let [take-xs (take-while #(<= % (first xs1)) xs2)
          drop-xs2 (drop (count take-xs) xs2)]
      [xs1 drop-xs2 take-xs])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; Time complexity: O((m+n)/2)
;; Space complexity: O((m+n)/2)
;;   We sort seq m and seq n until we reach the midpoint. It's possible to make
;;   adjustments such that it's O(1).
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn median-sorted-seq
  "We take sequences which is probably close enough to an array."
  ([xs1 xs2] (median-sorted-seq xs1 xs2 []))
  ([xs1 xs2 accumulator]
   (cond
     ;; Odd count.
     (> (count accumulator) (+ (count xs1) (count xs2)))
     (last accumulator)
     ;; Even count.
     (= (count accumulator) (+ (count xs1) (count xs2)))
     (/ (+ (last accumulator)
           (min (or (first xs1) (inc (first xs2)))
                (or (first xs2) (inc (first xs1)))))
        2.0)
     :else
     (let [[xs1* xs2* accumulator*] (take-until-other xs1 xs2)]
       (recur xs1* xs2* (concat accumulator accumulator*))))))
