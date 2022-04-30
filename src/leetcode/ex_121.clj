(ns leetcode.ex-121
  (:require [leetcode.util :refer [maplist]]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Best Time to Buy and Sell Stock
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; You are given an array prices where prices[i] is the price of a given stock
;; on the ith day.
;;
;; You want to maximize your profit by choosing a single day to buy one stock
;; and choosing a different day in the future to sell that stock.
;;
;; Return the maximum profit you can achieve from this transaction. If you
;; cannot achieve any profit, return 0.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn max-profit
  [prices]
  (->> (maplist (fn best-profit-for-day [prices]
                  (let [profit (- (apply max (or (next prices) [0]))
                                  (first prices))]
                    profit))
                prices)
       (apply max)
       (#(if (pos? %) % 0))))
