
(require '[clojure.pprint :refer (cl-format)])
(use '[clojure.string :only (join split)])

(defn parse-number
  "Reads a number from a string. Returns nil if not a number."
  [s]
  (if (re-find #"^-?\d+\.?\d*$" s)
    (read-string s)))
(defn parseorlookup[dataset key1]
  (if (nil? (parse-number key1))
                      (retrival dataset key1)
                      (parse-number key1)))

(defn makemap [filename]
  (into {}(map #(hash-map (keyword(last (split % #"-> ")))(first (split % #"-> ")))
     (split (slurp filename ) #"\n"))))
(def dataset (makemap "/users/stephenkinser/dayseven.txt"))
(get (makemap "/users/stephenkinser/dayseven.txt") :ir)
(count(split (get (makemap "/users/stephenkinser/dayseven.txt") :a) #" "))
(defn retrival ([dataset key1]
                (let [response (split (get dataset (keyword key1)) #" ")]
                  (cond ( = (count response) 1)
                          (parseorlookup dataset (first response))
                        (= (count response) 2)

                          (retrival dataset "not" (second response))
                        :else
                          ;(println (second response)  (first response)  (last response))
                          (retrival dataset (second response)  (first response)  (last response))
                        )))

  ([dataset rule key1]
    (let [monad (parseorlookup dataset key1)]
      (- 65535 monad)))

  ([dataset rule key1 key2]
   (let [left  (parseorlookup dataset key1)
         right (parseorlookup dataset key2)]
      (cond
       (= rule "AND") (bit-and left right)
       (= rule "OR")  (bit-or left right)
       (= rule "RSHIFT") (bit-shift-right left right)
       (= rule "LSHIFT") (bit-shift-left left right)
     ))))
;(nil?(re-seq #"[0-9]+"  (retrival (makemap "/users/stephenkinser/dayseven.txt") :a)))
(retrival (makemap "/users/stephenkinser/dayseven.txt") "c")
(retrival (makemap "/users/stephenkinser/dayseven.txt") "cy")
(retrival (makemap "/users/stephenkinser/dayseven.txt") "a")
;(bit-not(cl-format nil "2r~16,'0',B" 12))
(- 65535 123)
(bit-or 123 456)
(bit-and 123 456)
(bit-shift-left 123 2)
(bit-shift-right 456 2)
