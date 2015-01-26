(ns euler.problem-5)

(take 1 (for [x (iterate #(+ 20 %) 20)
        :when (empty?
               (filter zero? (map #(mod x %) (range 11 21))))] x))

(loop [x 20]
  (if (empty?
       (filter zero?
               (map #(mod x %) (range 11 21))))
    x
    (do
      (recur (+ 20 x)))))

(denfn lcm )

(defn gcd [a b] (if (zero? b) a (recur b (mod a b))))
(defn lcm [a b] (/ (* a b) (gcd a b)))
(reduce #(lcm %1 %2) (range 1 21))
