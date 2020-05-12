from unittest import TestCase

from src.main.python.td.problemsolving.leetcode.IncreasingDecreasingString import Solution


class TestSolution(TestCase):
    def test_sort_string(self):
        self.assertEqual('abccbaabccba', Solution().sortString('aaaabbbbcccc'))
        self.assertEqual('art', Solution().sortString('rat'))
        self.assertEqual('cdelotee', Solution().sortString('leetcode'))
        self.assertEqual('ggggggg', Solution().sortString('ggggggg'))
        self.assertEqual('ops', Solution().sortString('ops'))
