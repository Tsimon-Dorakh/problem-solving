module Expression where

expression :: Int -> Int -> Int -> Int
expression a b c =
    maximum [
          (a + b) + c
        , (a * b) * c
        , (a * b) + c
        , (a + b) * c
        , a + (b * c)
        , a * (b + c)
    ]
