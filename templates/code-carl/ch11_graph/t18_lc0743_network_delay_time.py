"""LeetCode 743. Network Delay Time
https://leetcode.cn/problems/network-delay-time/
"""

from typing import List


class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.networkDelayTime([[2, 1, 1], [2, 3, 1], [3, 4, 1]], 4, 2) == 2
    assert solution.networkDelayTime([[1, 2, 1]], 2, 1) == 1
    assert solution.networkDelayTime([[1, 2, 1]], 2, 2) == -1

    print("All tests passed.")
