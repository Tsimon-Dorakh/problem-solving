module MaxMult where

maxMultiple :: Int -> Int -> Int
maxMultiple d x | x `mod` d == 0 = x
                | otherwise      = maxMultiple d (x - 1)
