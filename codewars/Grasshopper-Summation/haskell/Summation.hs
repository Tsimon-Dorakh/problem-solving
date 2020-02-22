module Summation where

summation' :: Integer -> Integer
summation' n = div (n*(n + 1)) 2

summation :: Integer -> Integer
summation n = sum [1..n]

