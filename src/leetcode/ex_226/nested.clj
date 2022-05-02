(ns leetcode.ex-226.nested)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Invert Binary Tree
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Invert a binary tree.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; This problem is famous because the author of Homebrew got rejected from
;; Google because he couldn't or wouldn't do it.

;; Google: 90% of our engineers use the software you wrote (Homebrew), but you
;; can’t invert a binary tree on a whiteboard so fuck off.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; A binary tree can only have two child nodes meaning there can only be a left
;; and a right. When there is both a left and a right, swap the two.
;;
;; Time complexity: O(n)
;;   We visit every node once.
;; Space complexity: O(n)
;;   Our space usage is 1:1 with the size of our tree.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn invert-binary-tree [binary-tree]
  (cond (empty? binary-tree) []
        (and (nth binary-tree 2 nil)
             (nth binary-tree 1 nil))
        ;; Swap left and right.
        (conj
         (vector (first binary-tree))
         (invert-binary-tree (nth binary-tree 2 nil))
         (invert-binary-tree (nth binary-tree 1 nil)))
        ;; Only left present.
        (nth binary-tree 1 nil)
        (conj
         (vector (first binary-tree))
         (invert-binary-tree (nth binary-tree 1 nil)))
        :else ; No descendent nodes.
        (vector (first binary-tree))))
