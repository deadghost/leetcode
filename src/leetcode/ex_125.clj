(ns leetcode.ex-125
  (:require [clojure.string :as str]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Valid Palindrome
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; A phrase is a palindrome if, after converting all uppercase letters into
;; lowercase letters and removing all non-alphanumeric characters, it reads the
;; same forward and backward. Alphanumeric characters include letters and
;; numbers.
;;
;; Given a string s, return true if it is a palindrome, or false otherwise.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn palindrome? [s]
  (let [stripped-char-list
        (->> s
             str/lower-case
             (filter #(Character/isLetter %)))]
    (= stripped-char-list
       (reverse stripped-char-list))))
