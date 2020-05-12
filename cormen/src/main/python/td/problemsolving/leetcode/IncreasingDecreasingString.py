from typing import List

class Solution:
    def sortString(self, s: str) -> str:
        cs: List[int] = [0] * 26

        for c in s:
            cs[ord(c) - 97] += 1

        n: int = len(s)
        i: int = 0
        direction: int = 1
        result: str = ''

        while n > 0:
            if i < 0:
                direction = 1
            elif i == 26:
                direction = -1
            elif cs[i] > 0:
                cs[i] -= 1
                n -= 1

                result += chr(97 + i)

            i += direction

        return result
