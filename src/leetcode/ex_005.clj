(ns leetcode.ex-005)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Longest Palindromic Substring
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Given a string s, find the longest palindromic substring in s. You may assume
;; that the maximum length of s is 1000.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; We'll do this in two passes:
;; 1. Find beginning and ending indices of palindrome "centers". These are two
;;    of the same characters like "bb" and two of the same characters with one
;;    character in between such at "aba".
;; 2. For each "center" we expand the indices symmetrically until it is no
;;    longer a palindrome.

;; First pass.
(defn palindrome-centers
  "Returns a sequence of palindrome center start and end indices."
  ([s] (palindrome-centers (map-indexed vector s) []))
  ([s accumulator]
   (let [[[first-c-i first-c-val]
          [second-c-i second-c-val]
          [third-c-i third-c-val]] (take 3 s)
         two-c-pal-index (when (= first-c-val second-c-val)
                           [first-c-i second-c-i])
         three-c-pal-index (when (= first-c-val third-c-val)
                             [first-c-i third-c-i])]
     (if (empty? s)
       accumulator
       (recur (rest s)
              (-> accumulator
                  ((fn [acc] (if two-c-pal-index
                               (conj acc two-c-pal-index)
                               acc)))
                  ((fn [acc] (if three-c-pal-index
                               (conj acc three-c-pal-index)
                               acc)))))))))

;; Second pass.
(defn expand-palindrome [s [start-index end-index]]
  (if (and (not= start-index 0)
           (not= end-index (dec (count s)))
           (= (first (drop (dec start-index) s))
              (first (drop (inc end-index) s))))
    ;; Palindrome can be expanded.
    (recur s [(dec start-index) (inc end-index)])
    ;; No longer able to expand palindrome.
    (->> (drop start-index s)
         (take (- (inc end-index) start-index)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solution
;;==============================================================================
;; Time complexity: O(n^2)
;;   We look for palindrome centers in n time. We then look for full length
;;   palindromes for each center in n time.
;; Space complexity: O(n)
;;   We store each full palindrome until we find the max. This can be reduced to
;;   O(1) if we discard shorter results as we search.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn longest-palindromic-substr [s]
  (->> (palindrome-centers s)
       (map (partial expand-palindrome s))
       (apply max-key count)
       (apply str)))
