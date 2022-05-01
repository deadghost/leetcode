(ns leetcode.ex-021)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Merge Two Sorted Lists
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; You are given the heads of two sorted linked lists list1 and list2.
;; 
;; Merge the two lists in a one sorted list. The list should be made by
;; splicing together the nodes of the first two lists.
;; 
;; Return the head of the merged linked list.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn merge-sorted-lists
  [l1 l2]
  (cond
    ;; We have a result
    (and (empty? l1)
         (empty? l2))
    '()

    ;; Use head of l1
    (empty? l2)
    (conj (merge-sorted-lists
           (rest l1) l2)
          (first l1))

    ;; Use head of l2
    (empty? l1)
    (conj (merge-sorted-lists
           l1 (rest l2))
          (first l2))

    ;; head of l1 is smaller
    (< (first l1)
       (first l2))
    (conj (merge-sorted-lists
           (rest l1) l2)
          (first l1))

    :else ; head of l2 is smaller
    (conj (merge-sorted-lists
           l1 (rest l2))
          (first l2))))
