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

(defn index
  "Returns index where the first element of the seq is the index."
  [xs]
  (first xs))

(defn value
  "Returns value where the second element of the seq is the value."
  [xs]
  (second xs))

(defn two-sum?
  "sum - value of first item in xs can be found in the rest of xs."
  [xs sum]
  (let [i (first xs)
        j-val (- sum (value i))
        j (some #(when (= j-val (value %)) %) (rest xs))]
    (when j [i j])))

(defn maplist
  "Based on Common Lisp's maplist."
  [f coll]
  (if (empty? coll) nil
      (cons (f coll)
            (maplist f (rest coll)))))

(defn two-sum
  "Given an array of integers, return indices of the two numbers such that
  they add up to a specific target.
  We assume that each input has exactly one solution, and the same element
  is only used once."
  [xs sum]
  (->> (map-indexed vector xs)
       (maplist #(two-sum? % sum))
       (some identity)
       (map index)
       (time)))
