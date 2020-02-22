module DigPow where

import Data.Char

digits :: Integer -> [Integer]
digits = map (fromIntegral . digitToInt) . show

powerSum :: [Integer] -> Integer -> Integer
powerSum xs n = sum $ zipWith (^) xs [n..]

digpow :: Integer -> Integer -> Integer
digpow n p | x `mod` n == 0 = x `div` n
           | otherwise      = -1
  where x = powerSum (digits n) p
