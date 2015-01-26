(ns euler.problem-7)

(nth (for [x (iterate #(+ 2 %) 3)
           :when (not-any? zero? (map #(mod x %) (range 2 (+ 1 (Math/sqrt x)))))] x) 10000)
