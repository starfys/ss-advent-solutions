(use '[clojure.string :only (join split)])
;(split (slurp read-line) #"\n")

;(myget freq \a)(myget freq \e)(myget freq \i)(myget freq \o)(myget freq \u)


(defn myget [string search]
  (if (contains? string search) (get string search)
    ;else
    0
    ))

(defn evenodd[string]
[(join (map first (partition 1 2 (seq string))))
  (join (map first (partition 1 2 (next(seq string)))))])


 ;(map #(conj (seq (first %)) (seq(second %))) eo))
(defn mastermind[string]
  (loop [eo (evenodd string)]
;    (println (second (first eo))  (first (second eo)))
    (cond
     (nil? (first (first eo))) false
     (=  (first (first eo)) (first (second eo))) true
      (= (first (second eo))  (second (first eo))) true
     :else
      (recur [(next(first eo))(next(second eo))])
    )))

(defn nicestr [string]
  (let [freq(frequencies string) ]
     (and (>(reduce + (map #(myget freq %) [\a \e \i \o \u]))2)
          (nil?(some true? (map #(.contains string %)  ["ab" "cd" "pq" "xy"])))
          (mastermind string)
          ))
    )

;(split (slurp read-line) #"\n")
(frequencies(map #(nicestr %)  (split (slurp read-line) #"\n")))
;(nicestr (first(split (slurp read-line) #"\n")))
;(nicestr (second(split (slurp read-line) #"\n")))
(nicestr "haegwjzuvuyypxyu")

;( nil?(get (frequencies(second(split (slurp read-line) #"\n"))) \o))
;(contains? (frequencies(second(split (slurp read-line) #"\n"))) [\a \e \i \o \u])
;(nil?(some true? (map #(  .contains (second(split (slurp read-line) #"\n")) %)  ["ab" "cd" "pq" "xy"])))



;(first (evenodd (second(split (slurp read-line) #"\n"))))


(mastermind "ugknbfddgicrmopn" )
(mastermind "onbbhxrnmohzskgg")
(evenodd "abcddefghi")
(mastermind "abcddefghi")
(nicestr "ugknbfddgicrmopn")
(nicestr "dvszwmarrgswjxmb")

(defn dayfivetwo[string]
  (and(not(nil? (re-find #"(..).*\1" string )))
      (not(nil? (re-find #"(.).\1"  string )))))


(dayfivetwo "qjhvhtzxzqqjkmpb")
(frequencies(map #(dayfivetwo %) (split (slurp "/users/stephenkinser/dayfive.txt") #"\n")))

(and(not(nil?(re-find #"(.).\1" "qjhvhtzxzqqjkmpb")))
(not(nil?(re-find #"(..).*\1" "qjhvhtzxzqqjkmpb"))))