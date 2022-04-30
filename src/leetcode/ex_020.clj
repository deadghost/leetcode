(ns leetcode.ex-020)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Valid Parentheses
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Given a string s containing just the characters '(', ')', '{', '}', '[' and
;; ']', determine if the input string is valid.
;;
;; An input string is valid if:
;;
;;     1. Open brackets must be closed by the same type of brackets.
;;     2. Open brackets must be closed in the correct order.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def complement-chars
  {\( \)
   \) \(
   \[ \]
   \] \[
   \{ \} 
   \} \{})

(defn valid-parens?
  [s]
  (->> s
   (filter (set (keys complement-chars)))
   (reduce (fn accumulate-unpaired [acc char]
             (if (= (last acc)
                    (get complement-chars char))
               (vec (drop-last acc))
               (conj acc char)))
           [])
   (empty?)))
