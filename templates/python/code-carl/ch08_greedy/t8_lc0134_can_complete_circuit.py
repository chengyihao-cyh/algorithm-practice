"""LeetCode 134. Gas Station
https://leetcode.cn/problems/gas-station/
"""

from typing import List


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.canCompleteCircuit([1, 2, 3, 4, 5], [3, 4, 5, 1, 2]) == 3
    assert solution.canCompleteCircuit([2, 3, 4], [3, 4, 3]) == -1
    print("All tests passed.")
