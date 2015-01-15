(ns euler.problem-1)

(defn euler-1 [threshold divisors]
  (loop [number threshold
         sum 0]
    (cond (zero? number) sum
          (divides? number divisors)
          (recur number (+ number sum))
          :else (recur number sum)
          )))

(defn divides? [number divisors]
  (loop [divisors divisors]
    (cond (empty? divisors) false
          (zero? (mod number (first divisors))) true
          :else (recur (rest divisors)))))

(euler-1 1000 [3 5])
(divides? 10 [3 5])
