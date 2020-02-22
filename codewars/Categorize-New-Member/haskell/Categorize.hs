module Categorize where
import Types

toMembership :: (Int, Int) -> Membership
toMembership (age, handicap)
  | age >= 55 && handicap > 7 = Senior
  | otherwise = Open

openOrSenior :: [(Int, Int)] -> [Membership]
openOrSenior = map toMembership
