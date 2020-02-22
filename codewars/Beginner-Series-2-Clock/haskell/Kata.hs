module Kata (past) where

past :: Int -> Int -> Int -> Int
past h m s =
  h * 60 * 60 * 1000 +
  m * 60 * 1000 +
  s * 1000
