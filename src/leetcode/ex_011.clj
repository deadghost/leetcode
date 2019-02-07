(ns leetcode.ex-011)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Container With Most Water
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Given n non-negative integers a1, a2, ..., an , where each represents a point
;; at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
;; of line i is at (i, ai) and (i, 0). Find two lines, which together with
;; x-axis forms a container, such that the container contains the most water.
;; 
;; Note: You may not slant the container and n is at least 2.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; We lower the bound on the side with the shorter bar because the highest area
;; is limited by the shortest bar. I don't feel this is very intuitive.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; Time complexity: O(n)
;;   It's a single pass to solve.
;; Space complexity: O(1)
;;   We store only a few values.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn water-bars
  ([xs] (water-bars (map-indexed vector xs) 0))
  ([xs max-area]
   (let [[b1-i b1-v] (first xs)
         [b2-i b2-v] (last xs)
         new-area (* (- b2-i b1-i)
                     (min b1-v b2-v))]
     (cond
       ;; Exhausted sequence.
       (< (count xs) 2)
       max-area
       ;; Found higher area.
       (> new-area max-area)
       (recur (if (< b1-v b2-v)
                (drop 1 xs)
                (drop-last 1 xs))
              new-area)
       ;; Did not find higher area.
       :else
       (recur
        (if (< b1-v b2-v)
          (drop 1 xs)
          (drop-last 1 xs))
        max-area)))))
