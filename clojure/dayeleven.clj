(use '[clojure.string :only (join split)])
;(next(split "cqjxjnds" #""))

(get (frequencies "hijklmmn") \i)

;these do not work as expected
;(map #(get %2 %1) [\i \o \l](frequencies "cqjxjnds"))
;(map #(get %2 %1) [\i \o \l](frequencies "hijklmmn"))

;if this matches one of the collection map to nil
;(map #(nil? (get (frequencies "hijklmmn") %)) [\i \o \l])

;if any of these are nil, then it fails the test
;(every? true? (map #(nil? (get (frequencies "hijklmmn") %)) [\i \o \l]))

;convert items from array into
;(map #(int %)(seq "hijklmmn"))
;http://stackoverflow.com/questions/2720958/clojure-finding-sequential-items-from-a-sequence
(defn longest-initial-sequence [[x :as s]]
  (take-while identity (map #(#{%1} %2) s (iterate inc x))))
;(longest-initial-sequence (map #(int %)(seq "hijklmmn")))
;(longest-initial-sequence (map #(int %)(seq "abcdffaa")))
;will check if there is a sub string that is increasing, and that the length of the substring is >= 3
;(>= (count(longest-initial-sequence (map #(int %)(seq "abcdffaa")))) 3)

;sees if there is a repeated letter
;(not(nil?(re-find #"(.)\1+" "hijklmmn")))

;as per requirement, needs at least 2 that satisfy this condition
;(>= (count(re-seq #"(.)\1+" "abcdffaa")) 2)
;(>= (count(re-seq #"(.)\1+" "abcdfffa")) 2)

;need to write a number system that is base 26 (numbers in alphabet+1), but compatible with ascii
;(mod (-  (int \a) 97) 26)
;(mod (-  (int \z) 97) 26)
;(mod (- (inc(int \z)) 97) 26)


(defn base26inc[ intseq]
  (loop [index (dec(count intseq))
         currseq intseq]
    (cond (= index 0) currseq
          ;if increasing this would cause the 26^index to mod to 0 recur after updating the set
          (=(mod (- (inc(nth currseq index)) 97) 26) 0)
          (recur (dec index) (assoc currseq index 97))
          :else
          ;return the updated number
          (assoc currseq  index (inc (nth currseq index )))
          )))

;brief recap of how to access elements
;(dec(count(map #(int %)(seq "hijklmmn")) ))
;(nth (map #(int %)(seq "hijklmmn")) 7)
;figuring how assoc works
;(assoc (into [](map #(int %)(seq "hijklmmn"))) 7 8)

;test case on seq
;(into [](map #(int %)(seq "hijklmmn")))
;(base26inc (into [](map #(int %)(seq "hijklmmn"))))
;making sure it works if last item is z
;(base26inc (into [](map #(int %)(seq "hijklmmz"))))
;(base26inc (into [](map #(int %)(seq "hijklmzz"))))
;(every? true? [true true true false])
;(join #"" (map #(char %)(into [](map #(int %)(seq "hijklmzz")))))
;(join #"" (map #(char %)(base26inc(into [](map #(int %)(seq "hijklmzz"))))))


(defn upd-vec [input-vector ids new-values]
  (reduce-kv #(assoc %1 %3 (new-values %2)) input-vector ids))

;(longest-initial-sequence (map #(int %)(seq "hijklmmn")))
;(longest-initial-sequence (map #(int %)(seq "cqjxjnop")))
;(= 1 (- 2 1) (- 3 2))
(defn incsubseq [pass]
  (loop [start 0]
    (cond (= start 6) nil
          (=(nth  pass start) (- (nth pass(+ 1 start) )1)(- (nth pass (+ 2 start)) 2)) start
     :else (recur (inc start))))
  )
;(locOfsubseq (into [](map #(int %)(seq "hijklmmn"))))
;(locOfsubseq (into [](map #(int %)(seq "cqjxjnop"))))


;(defn skiptonext[pass]
;(if (=(locOfsubseq pass) 7)
;(let [start (nth pass 5)
;      index 5]
;      (upd-vec pass
;         [index (+ index 1) ( + index 2)]
;         [start (+ start 1) (+ start 2)]))
;)

;(skiptonext (into [](map #(int %)(seq "cqjxjnds"))))
;(join #"" (map #(char %)(skiptonext (into [](map #(int %)(seq "cqjxjnds"))))))
(defn dayeleven[ pass ]
  (loop [ currpass (into [](map #(int %)(seq pass)))]
    (if (every? true?
                (let [asciipass (join #"" (map #(char %) currpass))]
                [(every? true? (map #(nil? (get (frequencies asciipass) %)) [\i \o \l]))
                 (not(nil?(incsubseq currpass)))
                 (>= (count(re-seq #"(.)\1+" asciipass)) 2)]))
      (join #"" (map #(char %) currpass))
      ;else, note that there are optimizations, I will skip, for example if it fails during increase, skip 26^index fail
      (recur (base26inc currpass)))))
;test input to make sure the first works
;    (dayeleven "abcdefgh")
;to make sure this works
(dayeleven "cqjxjnds")

;dirty hack to get the next correct password
(dayeleven(join #"" (map #(char %)
                    (base26inc (into [](map #(int %)(seq (dayeleven "cqjxjnds"))))))))
;(+ 41 46 -2 54 83 -7 60 55)
