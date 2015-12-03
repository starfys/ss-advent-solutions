;should remove my class path/ learn how to read from working directory
(defn dayone [filename] (let [ file (frequencies(slurp filename ))]
              (- (second (first  file)) (second( second file)))))
(dayone (read-line))

; (second (first (frequencies (slurp (read-line)))))

(seq (slurp read-line))
(defn curly [string] (if (= \( string) 1 -1))
;(map curly (seq (slurp read-line)))
;(= \( (first(seq (slurp read-line))))
;the elegant solution is in this line of code
;(take-while #(> % 0) (iterate inc (map curly(seq (slurp read-line)))))
;(iterate (partial + 2) 0)

(defn recursion[item pos sum]
  (if ( = (+(first item) sum) -1) pos
    (recursion (rest item) (+ pos 1) (+ sum (first item)))))


(recursion   (map curly(seq (slurp read-line))) 1 0)

;(reduce +(range 1 100))
(;take-while #(> (gz %) 0)  (map curly(seq (slurp read-line))))
