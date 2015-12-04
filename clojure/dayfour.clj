;from rosetta code
(defn md5 [string]
  (apply str
  (map (partial format "%02x")
    (.digest (doto (java.security.MessageDigest/getInstance "MD5")
                   .reset
                   (.update (.getBytes string)))))))

(md5 (clojure.string/join "" ["abcdef" 609043]))
;a match gives back output
(re-matches #"00000.*" (md5 (clojure.string/join "" ["abcdef" 609043])))
;a not match gives back nil
(re-matches #"000000.*" (md5 (clojure.string/join "" ["abcdef" 609043])))
;testing this on nil? gives true
(nil?(re-matches #"000000.*" (md5 (clojure.string/join "" ["abcdef" 609043]))))
;the lazy recursive way, maybe figure out a map / reduce
;actually, causes a stack overflow
;uses recur to do tail recursion optimization
(defn dayfour [string]
  (loop [input string acc 0]
  (if (nil?(re-matches #"00000.*" (md5 (clojure.string/join "" [input acc]))))
    (recur input (inc acc))
    ;else
    acc
  )))

(dayfour "abcdef")
;my input
(dayfour "yzbqklnj")
;note that this takes forever
(defn dayfour-two [string]
  (loop [input string acc 282749]
  (if (nil?(re-matches #"000000.*" (md5 (clojure.string/join "" [input acc]))))
    (recur input (inc acc))
    ;else
    acc
  )))
(dayfour-two "yzbqklnj")