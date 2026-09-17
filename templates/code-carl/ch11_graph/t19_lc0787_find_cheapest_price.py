"""LeetCode 787. Cheapest Flights Within K Stops
https://leetcode.cn/problems/cheapest-flights-within-k-stops/
"""

from typing import List


class Solution:
    def findCheapestPrice(
        self, n: int, flights: List[List[int]], src: int, dst: int, k: int
    ) -> int:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.findCheapestPrice(4, [[0, 1, 100], [1, 2, 100], [2, 0, 100], [1, 3, 600], [2, 3, 200]], 0, 3, 1) == 700
    assert solution.findCheapestPrice(3, [[0, 1, 100], [1, 2, 100], [0, 2, 500]], 0, 2, 1) == 200
    assert solution.findCheapestPrice(3, [[0, 1, 100], [1, 2, 100], [0, 2, 500]], 0, 2, 0) == 500

    print("All tests passed.")
