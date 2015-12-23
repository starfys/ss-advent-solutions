(use '[clojure.string :only (join split)])
(defn multinths[currlist
                nthnums]
  (map #(read-string (nth currlist %)) nthnums)
  )
(def dataset(map #( multinths (split % #" ")[3 6 13])
     (split (slurp "/Users/stephenkinser/Projects/advent-io/day14/Riuchando.input")#"\n")))
(def seconds 2503)

(def dataset(map #( multinths (split % #" ")[3 6 13])
     (split (slurp "/Users/stephenkinser/Projects/advent-io/day14/test.input")#"\n")))
(def seconds 1000)

(map #(+ (nth % 1)(nth % 2))  dataset )

;(let [remainder (map #(mod seconds (+ (nth % 1)(nth % 2)) ) dataset )
;      move (map #(nth % 1) dataset)
;     velocity (map #(nth % 0) dataset)]
;  (if (> remainder move) (* move velocity)
;    ;else
;    (* remainder velocity)
;    ))

;(mod seconds 137)
;(int (/ 2503 137))
;(+(* 7 14 10)
;(* 10 14))
;(mod seconds 176)
;(+(* (int (/ seconds 176)) 16 11 )(* 11 16))

;(mod seconds 137)
;(* 14 37)
;(remainder 37 5 27)
;(* (int (/ 2053 137)) (* 27 5))

;(map #(mod seconds (+ (nth % 1)(nth % 2)) ) dataset )
;(map #(nth % 1) dataset)
;(map #(nth % 0) dataset)
(defn remainder [remainder move velocity]
  (if (> remainder move) (* move velocity)
    ;else
    (* remainder velocity)
    ))
(into [] dataset)

;(map #( remainder %1 %2 %3)
;     (map #(mod seconds (+ (nth % 1)(nth % 2)) ) dataset )
;     (map #(nth % 1) dataset)
;     (map #(nth % 0) dataset))


;(map #(distance  (* %2 %3) (+ %2 %4))
;     (map #(mod seconds (+ (nth % 1)(nth % 2)) ) dataset )
;     (map #(nth % 1) dataset)
;     (map #(nth % 0) dataset)
;     (map #(nth % 2) dataset ))


(map #(+ (distance  (* %2 %3) (+ %2 %4)) (remainder %1 %2 %3) )
     (map #(mod seconds (+ (nth % 1)(nth % 2)) ) dataset )
     (map #(nth % 1) dataset)
     (map #(nth % 0) dataset)
     (map #(nth % 2) dataset ) )


(defn distance[move velocity ]
               (* (int (/ seconds velocity)) move))


