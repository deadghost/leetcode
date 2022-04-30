(ns leetcode.ex-001.hashmap)

;; Similar to bruteforce except we check the result with a hashmap which
;; has much faster lookup time.

;; We convert the array to a hashmap for cheap lookups at the cost of a one
;; time conversion.

(defn xs->m
  "Convert seq to map of val:indices pairs."
  ([xs] (xs->m xs 0 {}))
  ([xs i acc]
   (if (< i (count xs))
     (recur xs (inc i) (update acc (get xs i) #(conj % i)))
     acc)))

(defn two-sum? [m x sum]
  (let [y (- sum x)]
    (if (= x y)
      (when (>= (count (get m x)) 2)
        [(second (get m x))
         (first (get m x))])
      (when-let [y-indices (get m y)]
        [(first (get m x)) (first y-indices)]))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; Time complexity: O(n)
;;   We pay a one time cost to create a hashmap for fast lookups.
;;   For every element, we check the hashmap for its complement.
;; Space complexity: O(1)
;;   We only keep track of certain variables.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn two-sum
  "Given an array of integers, return indices of the two numbers such that
  they add up to a specific target.
  We assume that each input has exactly one solution, and the same element
  is only used once."
  [xs sum]
  (let [m (xs->m xs)]
    (some #(two-sum? m % sum) xs)))
