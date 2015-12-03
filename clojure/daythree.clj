(defn newspot [command pos]
  (cond
   (= command \>) [(+ 1 (first pos ) ) (second pos)]
    (= command \^)[ (first pos )  (+ 1 (second pos))]
     (= command \< ) [ (- (first pos ) 1) (second pos)]
     :else ;v
       [ (first pos )  (-  (second pos) 1)]
   ))


(newspot (first (seq(slurp read-line))) [0 0])

(doseq [item (seq(slurp read-line))]
            (prn item ))



(conj [] [0 0] [0 1])
(count (conj [][0 1]))
(conj (conj [] [0 0] [0 1]) [1 0])
(last(conj (conj [] [0 0] [0 1]) [1 0]))
(defn recursion [commands positions]
  (if( empty? commands) positions
    (recursion (rest commands)
               (if (empty? positions)
                 (conj [] [0 0] (newspot (first commands) [0 0])  )
                 (conj positions (newspot (first commands) (last positions)))))))

(defn daythree [filename ]
  (count (frequencies (recursion (seq(slurp filename))[]))))

;(conj [] (newspot (first (seq(slurp read-line))) [0 0]) [0 0])
; (let [positions (conj [] [0 0] (newspot (first (seq(slurp read-line))) [0 0]))
;       commands (seq(slurp read-line))]
;   (second commands))
;       (conj positions (newspot (second commands) (last positions ))))
; (newspot (second commands) [0 0]))
