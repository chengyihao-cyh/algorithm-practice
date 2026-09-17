"""LeetCode 739. Daily Temperatures
https://leetcode.cn/problems/daily-temperatures/
"""

from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]) == [1, 1, 4, 2, 1, 1, 0, 0]
    assert solution.dailyTemperatures([30, 40, 50, 60]) == [1, 1, 1, 0]
    assert solution.dailyTemperatures([30, 60, 90]) == [1, 1, 0]

    print("All tests passed.")
