(ns leetcode.util)

(defn maplist
  "Based on Common Lisp's maplist."
  [f coll]
  (if (empty? coll) nil
      (cons (f coll)
            (maplist f (rest coll)))))
