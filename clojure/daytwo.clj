(use '[clojure.string :only (join split)])
 ;(map  #( split % #"x") (split (slurp read-line) #"\n"))
 ;(map #(map read-string % )(map  #( split % #"x") (split (slurp read-line) #"\n")))
;(map  #( map read-string (split % #"x")) (split (slurp read-line) #"\n"))
;(map  #( reduce +  (map read-string (split % #"x"))) (split (slurp read-line) #"\n"))

(defn formatfile[filename] (map  #(map  read-string (split % #"x")) (split (slurp filename) #"\n")))

(formatfile read-line)
;(map  #(apply min %) (formatfile read-line))
;(map  #(apply + %)  (formatfile read-line))


;(reduce +(map  #(apply min %) (formatfile read-line)))
;(reduce + (map #( * % 2) (map  #(apply + %)  (formatfile read-line))))
;(reduce +(map  #(apply + %)  (formatfile read-line)))



(defn rotate[mylist] (concat (rest mylist) [(first mylist)] ))
;(rotate(first(formatfile read-line)))
;(map * (first(formatfile read-line)) (rotate(first(formatfile read-line))))

(defn lw [nums] (map  #(map * % (rotate %)) nums))

(lw (formatfile read-line))

(defn daytwo[filename]
  (let[nums (lw(formatfile filename))]
    (reduce + (concat(map #( * % 2) (map  #(apply + %) nums))
            (map  #(apply min %) nums)))))

(daytwo read-line)
