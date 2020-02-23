module Main where

import Control.Applicative
import Control.Monad
import System.IO
import qualified Data.Map as Map
import Control.Monad.State

readAInt :: IO Int
readAInt = readLn

parsePair :: String -> (Int, Int)
parsePair xs = let [w1, w2] = words xs in (read w1, read w2)

readIntPair :: IO (Int, Int)
readIntPair = fmap parsePair getLine

readTestCase :: IO [(Int, Int)]
readTestCase =
  readAInt >>= flip replicateM readIntPair

isValidCase :: Map.Map Int Int -> (Int, Int) -> Bool
isValidCase m (x, y) | Map.notMember x m = True
                     | otherwise         = m Map.! x == y

addCase :: (Int, Int) -> Map.Map Int Int -> Map.Map Int Int
addCase (x, y) = Map.insert x y

check :: (Int, Int) -> State (Map.Map Int Int) Bool
check x = state (\s -> (isValidCase s x, addCase x s))

checkCase :: [(Int, Int)] -> Bool
checkCase xs =
  evalState (
    foldM (\r a -> if r then check a else falseState) True xs
  ) Map.empty
  where falseState = state (\s -> (False, s))

runTestCase :: IO ()
runTestCase =
  readTestCase >>= \xs ->
    if checkCase xs
    then putStrLn "YES"
    else putStrLn "NO"

main :: IO ()
main =
  readAInt >>= flip replicateM_ runTestCase
