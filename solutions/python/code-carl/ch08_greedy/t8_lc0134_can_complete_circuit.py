"""LeetCode 134. Gas Station
https://leetcode.cn/problems/gas-station/
"""

from typing import List


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        start_idx = 0
        total_gas = 0
        curr_gas = 0

        for i, (g, c) in enumerate(zip(gas, cost)):
            total_gas += g - c
            curr_gas += g - c
            if curr_gas < 0:
                start_idx = i + 1
                curr_gas = 0

        return start_idx if total_gas >= 0 else -1


if __name__ == "__main__":
    solution = Solution()
    assert solution.canCompleteCircuit([1, 2, 3, 4, 5], [3, 4, 5, 1, 2]) == 3
    assert solution.canCompleteCircuit([2, 3, 4], [3, 4, 3]) == -1
    print("All tests passed.")
