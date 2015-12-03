;should remove my class path/ learn how to read from working directory
(defn dayone [filename] (let [ file (frequencies(slurp filename ))]
              (- (second (first  file)) (second( second file)))))
(dayone "/Users/stephenkinser/Projects/ss-advent-solutions/clojure/dayone.txt")
; (second (first (frequencies (slurp "/Users/stephenkinser/Projects/ss-advent-solutions/clojure/dayone.txt"))))
;  (second (second (frequencies (slurp "/Users/stephenkinser/Projects/ss-advent-solutions/clojure/dayone.txt"))))

