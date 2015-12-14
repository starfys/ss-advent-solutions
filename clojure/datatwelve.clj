(use '[clojure.string :only (join split)])
(reduce + (map #(read-string %)
               (re-seq #"-?\d+" (slurp "/Users/stephenkinser/Projects/advent-io/day12/Riuchando.input"))))
(reduce + (map #(read-string %)
(re-seq #"-?\d+" (clojure.string/replace
                  (slurp "/Users/stephenkinser/Projects/advent-io/day12/Riuchando.input")
                  #"\{(.*\"red\".*?)\}" ""))))


(reduce + (map #(read-string %)
(re-seq #"-?\d+" (clojure.string/replace
                  (slurp "/Users/stephenkinser/Projects/advent-io/day12/Riuchando.input")
                  #"\{([^}]+)\}" ""))))

(reduce + (map #(read-string %)
        (re-seq #"-?\d+" (clojure.string/replace
              (slurp "/Users/stephenkinser/Projects/advent-io/day12/Riuchando.input")
                  #"\{(.*red.*)\}" ""))))



(reduce + (map #(read-string %)
(re-seq #"-?\d+" (clojure.string/replace
                  (slurp "/Users/stephenkinser/Projects/advent-io/day12/Riuchando.input")
                  #"\{((\s*?.*?)*?)\}" ""))))

(clojure.string/replace "{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}" #"\{((\s*?.*?)*?)\}" "")
(clojure.string/replace "[1,{\"c\":\"red\",\"b\":2},3]" #"\{((\s*?.*?)*?)\}" "")
(reduce + (map #(read-string %)
               (re-seq #"-?\d+"
                (clojure.string/replace "[1,{\"c\":\"red\",\"b\":2},3]" #"\{((\s*?.*?)*?)\}" ""))))

(reduce + (map #(read-string %)
          (remove  nil? (flatten
            (map #(re-seq #"-?\d+" %)
                 (flatten
              (re-seq #"\{([^\{])*red([^\}])*\}" (slurp "/Users/stephenkinser/Projects/advent-io/day12/Riuchando.input")))
                 )))))

(- 156366 94710)

(count(re-seq #"\{[^\{]*red[^\}]*\}" (slurp "/Users/stephenkinser/Projects/advent-io/day12/Riuchando.input")))

;["{\"e\":-14,\"a\":\"red\",\"d\":
  ;{\"c\":\"yellow\",\"a\":[-35,0],\"b\":\"orange\",\"d\":
  ;{\"e\":70,\"a\":\"green\",\"d\":\"blue\",\"j\":12,\"c\":69,\"h\":\"orange\",\"b\":92,\"g\":\"yellow\",\"f\":\"green\",\"i\":121}
  ;" "\"" "1"]

;["{\"e\":-14,\"a\":\"red\",\"d\":
  ;{\"c\":\"yellow\",\"a\":[-35,0],\"b\":\"orange\",\"d\":
  ;{\"e\":70,\"a\":\"green\",\"d\":\"blue\",\"j\":12,\"c\":69,\"h\":\"orange\",\"b\":92,\"g\":\"yellow\",\"f\":\"green\",\"i\":121}
  ;" "\"" "1" "1" nil]

(first(re-seq #"\{([^\{])*red(\{[^\{\}]*\})*\}"
               (slurp "/Users/stephenkinser/Projects/advent-io/day12/Riuchando.input")))
(map #(re-find #"red" %) (split (slurp "/Users/stephenkinser/Projects/advent-io/day12/Riuchando.input") #"\{"))

(reduce + (map #(read-string %)
          (remove  nil?
          (flatten(map #(re-seq #"-?\d+" %)
          (filter #(re-find #"red" %)
                  (split (slurp "/Users/stephenkinser/Projects/advent-io/day12/Riuchando.input") #"\{")))))))
