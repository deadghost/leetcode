(ns leetcode.ex-226.row-reversal)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Approach
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; We observe that each row in the tree is reversed.
;; We'll go through the tree row by row and reverse the values.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn invert-binary-tree
  [tree]
  (loop [remaining-tree tree
         depth 0
         acc []]
    (if (seq remaining-tree)
      (let [row-count (Math/pow 2 depth)]
        (recur
         (drop row-count remaining-tree)
         (inc depth)
         (->> (take row-count remaining-tree)
              (reverse)
              (into acc))))
      acc)))
