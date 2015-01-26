(ns euler.problem-6)

(let [x (range 1 101)] (- (#(* % %) (apply + x)) (apply + (map #(* % %) x))))

(-
  (let [v (reduce + (range 1 101))] (* v v))
  (reduce + (for [n (range 1 102)] (* n n))))
