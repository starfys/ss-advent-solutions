(use '[clojure.string :only (join split)])

;(re-seq #"(\d)\1+" "122211")
;(first (first(re-seq #"(\d)\1+" "122211")))


;initial prototyping, not the most familiar with perl regex conventions
;(map #(count (first %)) (re-seq #"(\d)\1*" "122211"))
;(map #(read-string (second %)) (re-seq #"(\d)\1*" "122211"))


;making sure the join command turns a seq of numbers into one long string
;(join "" (interleave
 ;(map #(count (first %)) (re-seq #"(\d)\1*" "122211"))
 ;(map #(read-string (second %)) (re-seq #"(\d)\1*" "122211"))))


(defn say[number] (join ""(interleave
 (map #(count (first %)) (re-seq #"(\d)\1*" number))
 (map #(read-string (second %)) (re-seq #"(\d)\1*" number)))
))
;should output 11
;(say "1")

(defn dayten[number]
  (loop [init 0
         currnum number]
    (if (= init 40)(count currnum)
      ;else
      (recur (+ 1 init) (say currnum) )
    )))
;put your sting in there
;dayten "1321131112")
;it takes considerably longer, maybe should find the math equation that gives this
 (defn parttwo[number]
  (loop [init 0
         currnum number]
    (if (= init 50)(count currnum)
      ;else
      (recur (+ 1 init) (say currnum) )
    )))
;(parttwo "1321131112")
;(map #(split  "122211" (re-pattern(first %)))   (re-seq #"(\d)\1*" "122211"))
;(split "122211" #"222")
;(split "122211" #"11")
