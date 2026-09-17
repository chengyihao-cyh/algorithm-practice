"""LeetCode 474. Ones and Zeroes
https://leetcode.cn/problems/ones-and-zeroes/
"""

from typing import List


class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.findMaxForm(['10', '0001', '111001', '1', '0'], 5, 3) == 4
    assert solution.findMaxForm(['10', '0', '1'], 1, 1) == 2
    print("All tests passed.")
