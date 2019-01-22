(ns leetcode.ex-001)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Two Sum
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Given an array of integers, return indices of the two numbers such that
;; they add up to a specific target.
;; 
;; You may assume that each input would have exactly one solution, and you
;; may not use the same element twice.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Indices are tricky in clojure.
;; [...] there's a reason this(position fn) isn't included in clojure.core: it's 
;; not very efficient, and you very rarely care about indices in a collection -
;; if you do, you should usually rethink your algorithm.
;; - amalloy

(defn two-sum? [xs sum]
  (let [i (first xs)
        j (- sum i)]
    (when (some #(= j %) (rest xs))
      [i j])))

(defn maplist
  "Based on Common Lisp's maplist."
  [f coll]
  (if (empty? coll) nil
      (cons (f coll)
            (maplist f (rest coll)))))

(defn index-pair
  "Returns indices of v1 and v2 in xs. We need to do it this way because
  simply mapping .indexOf can result in a duplicate index if both v1 and v2 are
  the same value."
  [xs [v1 v2]]
  (let [index1 (.indexOf xs v1)
        index2 (+ 1 index1 (.indexOf (drop (inc index1) xs) v2))]
    [index1 index2]))

(defn two-sum [xs sum]
  (->> (some identity (maplist #(two-sum? % sum) xs))
       (index-pair xs)))
