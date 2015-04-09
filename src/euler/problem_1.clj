(ns euler.problem-1)

(defn divides? [number divisors]
  (loop [divisors divisors]
    (cond (empty? divisors) false
          (zero? (mod number (first divisors))) true
          :else (recur (rest divisors)))))

(defn euler-1 [threshold divisors]
  (loop [number (dec threshold)
         sum 0]
    (cond (zero? number) sum
          (divides? number divisors)
          (recur (dec number) (+ number sum))
          :else (recur (dec number) sum)
          )))

(euler-1 1000 [3 5])

;; or like this
(apply + (filter #(divides? % [3 5]) (range 1000)))

;; do the same

;; sum of multiples progression minus least common multiple progression
(apply - (apply + (concat (range 3 1000 3) (range 5 1000 5))) (range 15 1000 15))

;; sum of progressions union
(apply + (set (concat (range 3 1000 3) (range 5 1000 5))))

;; lazy seq
(apply + (for [x (range 1000)
              :when (or (zero? (mod x 3)) (zero? (mod x 5)))]
          x))

;; state
(let [sum (atom 0)]
  (doseq [x (range 1000)
          :when (or (zero? (mod x 3)) (zero? (mod x 5)))]
    (swap! sum + x))
  @sum)
