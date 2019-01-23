(ns leetcode.ex-002)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Add Two Numbers
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; You are given two non-empty linked lists representing two non-negative
;; integers. The digits are stored in reverse order and each of their nodes
;; contain a single digit. Add the two numbers and return it as a linked list.
;; 
;; You may assume the two numbers do not contain any leading zero, except the
;; number 0 itself.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn add-two-numbers
  ([l1 l2] (add-two-numbers l1 l2 '()))
  ([l1 l2 accumulator]
   (let [l1-i (or (first l1) 0)
         l2-i (or (first l2) 0)]
     (cond
       ;; Terminating condition, both lists have been exhausted.
       (and (empty? l1) (empty? l2)) accumulator
       ;; Sum >= 10, we need to inc next sum and -10 from this sum.
       (>= (+ l1-i l2-i) 10)
       (recur (rest l1)
              (conj (rest (rest l2))
                    (inc (first (rest l2))))
              (concat accumulator (list (- (+ l1-i l2-i) 10))))
       ;; Default recur, sum < 10.
       :else (recur (rest l1)
                    (rest l2)
                    (concat accumulator
                            (list (+ l1-i l2-i))))))))
