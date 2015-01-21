(ns euler.problem-4
  (:require [clojure.string :as s]))

(take 10 (iterate #(- % 2) 999))

(for [x (take 100 (iterate dec 999))
         y (take 100 (iterate dec 998))
         :let [product (* x y)]
         :when (= (.toString product) (s/reverse (.toString product)))]
     product)

(= (.toString 999) (s/reverse (.toString 999)))
