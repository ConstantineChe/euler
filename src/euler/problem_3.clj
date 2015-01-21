(ns euler.problem-3)

(defn fermat [n]
  (loop [a (Math/round (Math/sqrt n))]
    (let [b2 (- (* a a) n)]
      (if (== (Math/round (Math/sqrt b2)) (Math/sqrt b2))
        (if (isprime? (+ a (Math/sqrt b2)))
          (+ a (Math/sqrt b2)))
        (recur (dec a))))))

(defn div-method [n]
  (loop [b (dec n)]
    (if (zero? (mod n b))
      (if (isprime? b) b
        (recur (dec b))))))

(let [n 600851475143]
  (loop [counter 2
         test n
         fact 0]
    (if (>= (* counter counter) test) test
      (if (zero? (mod test counter))
        (recur counter (/ test counter) counter)
        (recur (inc counter) test fact)))))

(largest-fact 5959)

(defn factors [x]
  (filter #(zero? (mod x %)) (take-while #(>= x (* % %)) (range 2 x))))
(defn lpf [x]
  (filter #(empty? (factors %)) (factors x)))

(time (lpf 600851475143))

(largest-fact 600851475143)

(fermat 600851475143)

(isprime? 101)

(fermat 5959)

(print (div-method 600851475143))

(div-method 5959)

(isprime? 11)

(defn isprime? [n]
  (if (or (zero? (mod n 2)) (zero? (mod n 3)))
    false
    (loop [i 5]
      (if (<= n (* i i))
        true
        (if (or (zero? (mod n i)) (zero? (mod n (+ 2 i))))
          false
          (recur (+ i 6)))))))
