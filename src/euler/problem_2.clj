(ns euler.problem-2
  (:require [clojure.core.match :refer [match]]))

(def fib-seq  (lazy-cat [0 1] (map + (rest fib-seq) fib-seq)))
(apply + (for [x fib-seq
                      :while (<= x 4000000)
                      :when (even? x)] x))

(defn fib2 [max]
  (loop [fibs (list 2 1)]
    (if (> (first fibs) max)
      fibs
      (recur (conj fibs (+
                         (first fibs)
                         (second fibs)))))))

(apply + (filter even? (fib2 4000000)))

(defn fib-match
      [n]
      (match [n]
             [0] 0
             [1] 1
             [_] (+ (fib-match (dec n)) (fib-match (- n 2)))))

(fib-match 15)
