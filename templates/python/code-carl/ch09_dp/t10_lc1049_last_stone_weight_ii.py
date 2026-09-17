"""LeetCode 1049. Last Stone Weight II
https://leetcode.cn/problems/last-stone-weight-ii/
"""

from typing import List


class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.lastStoneWeightII([2, 7, 4, 1, 8, 1]) == 1
    assert solution.lastStoneWeightII([31, 26, 33, 21, 40]) == 5
    print("All tests passed.")
