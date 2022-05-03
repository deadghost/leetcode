(ns leetcode.ex-733)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Flood Fill
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; An image is represented by an m x n integer grid image where image[i][j]
;; represents the pixel value of the image.
;; 
;; You are also given three integers sr, sc, and newColor. You should perform a
;; flood fill on the image starting from the pixel image[sr][sc].
;; 
;; To perform a flood fill, consider the starting pixel, plus any pixels
;; connected 4-directionally to the starting pixel of the same color as the
;; starting pixel, plus any pixels connected 4-directionally to those pixels
;; (also with the same color), and so on. Replace the color of all of the
;; aforementioned pixels with newColor.
;; 
;; Return the modified image after performing the flood fill.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn flood-fill
  [{:keys [grid starting-row-index starting-col-index new-color]}]
  (let [old-color (get-in grid [starting-row-index starting-col-index])]
    (loop [indices-to-check (list [starting-row-index starting-col-index])
           new-grid grid]
      (let [current-position (first indices-to-check)
            [row-index col-index] current-position]
        (cond
          (empty? indices-to-check)
          new-grid

          (= (get-in new-grid current-position)
             old-color)
          (recur
           (into (pop indices-to-check)
                 ;; 4 directions
                 (list [row-index (inc col-index)]
                       [row-index (dec col-index)]
                       [(inc row-index) col-index]
                       [(dec row-index) col-index]))
           (assoc-in new-grid current-position new-color))

          :else
          (recur (pop indices-to-check) new-grid))))))
