(use '[clojure.string :only (join split)])
;always make sure it reads in
(split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")
;(second(split (slurp "/Users/stephenkinser/dayeight.txt") #"\n"))
;(re-seq #"\\\\" (second(split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")) )

;(count(re-seq #"\\\"" (second(split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")) ))
;(count(re-seq #"\\x[a-f0-9]{2}"(second(split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")) ))
;(+(count(seq  "abc"))(count "aaa\"aaa")(count "\x27"))

;(reduce +(map #(count %) (split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")) )
;(reduce +(map #(weirdparse %) (split (slurp "/Users/stephenkinser/sample.txt") #"\n")) )


; need to fix this one
(reduce +(map #(weirdparse %)(split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")))
;(reduce +(map #(weirdparse %)["\"\"" "\"abc\"" "\"aaa\\\"aaa\"" "\"\\\x27\""]))
;prototype
;(reduce +(map #( + 2 (count (re-seq #"\\\"" %) )
;                     (count (re-seq #"\\\\" %) )
;                    (* 3(count (re-seq #"\\x[a-f0-9]{2}" %))))
;              ["" "abc" "aaa\\\"aaa" "\\x27"]))

;(map #(re-seq #"\\x[a-f0-9]{2}" %) ["\\x27"])
;(re-seq #"\\x[a-f0-9]{2}" "\\x27")

;more prototyping before I realized neither re-seq or re-find does what I want
;(count (re-seq #"\"" (first (split (slurp "/Users/stephenkinser/sample.txt") #"\n"))))
;(nth (split (slurp "/Users/stephenkinser/sample.txt") #"\n")1)
;(count (re-seq #"\"" (nth (split (slurp "/Users/stephenkinser/sample.txt") #"\n")1) ))
;(nth (split (slurp "/Users/stephenkinser/sample.txt") #"\n")2)
;(count (re-seq #"\\\"" (nth (split (slurp "/Users/stephenkinser/sample.txt") #"\n")2)))

;this is the corresponding function
(defn weirdparse[string]
            (+ 2 (count (re-seq #"\\\\" string))
                 (count (re-seq #"\\\"" string) )
                  (* 3(count (re-seq #"\\x[a-f0-9]{2}" string)))))

;more prototyping
;(weirdparse (second(split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")))

;(count (second(split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")))
;(count (seq (second(split (slurp "/Users/stephenkinser/dayeight.txt") #"\n"))))
;(nth (split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")4)
;(weirdparse(nth (split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")4))
;(count(read-string (nth (split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")4)))
;(count (nth (split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")4))


;(re-find #"\\(\\|\"|(x[a-f0-9]{2}))"  (nth (split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")10))

;the beginning prototyping with string replace
;(clojure.string/replace (nth (split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")10) #"\\\\" "1")
;(clojure.string/replace(clojure.string/replace (clojure.string/replace (nth (split (slurp "/Users/stephenkinser/dayeight.txt") #"\n")10)#"\\\"" "1")#"\\\\" "1") #"\"" "")

;man I hate this one
(defn badreplace [string]
  (clojure.string/replace
   (clojure.string/replace
    (clojure.string/replace
     (clojure.string/replace string #"\\\\" "_")
                                     #"\\\"" "_")
                                      #"\"" "")
                                      #"\\x[a-f0-9]{2}" "_"))
;the actually working function
(defn dataset[data]
(-(reduce +(map #(count %) data) )
  (reduce +(map #(count (badreplace %)) data) )))
;(dataset (split (slurp "/Users/stephenkinser/sample.txt") #"\n"))
(dataset (split (slurp "/Users/stephenkinser/dayeight.txt") #"\n"))

(defn horriblereplace [string]
    (clojure.string/replace
     (clojure.string/replace string #"\\" "__")
                                     #"\"" "__"))
;(count(clojure.string/replace (first(split (slurp "/Users/stephenkinser/sample.txt") #"\n")) #"\"" "\\\\\""))
;(count(clojure.string/replace (second(split (slurp "/Users/stephenkinser/sample.txt") #"\n")) #"\"" "\\\\\""))

;(map #(horriblereplace %) (split (slurp "/Users/stephenkinser/sample.txt") #"\n"))
;(map #(+ 2 (count(horriblereplace %))) (split (slurp "/Users/stephenkinser/sample.txt") #"\n"))

(defn parttwo [data]
(-
  (reduce +(map #( +  2 (count (horriblereplace %))) data))
   (reduce +(map #(  count  %) data))))
;regex isn't doing what I want
(parttwo (split (slurp "/Users/stephenkinser/dayeight.txt") #"\n"))
;(parttwo (split (slurp "/Users/stephenkinser/sample.txt") #"\n"))

