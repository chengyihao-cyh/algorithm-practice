"""LeetCode 77. Combinations
https://leetcode.cn/problems/combinations/
"""

from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        pass


if __name__ == "__main__":
    solution = Solution()
    result = {tuple(x) for x in solution.combine(4, 2)}
    expected = {(1, 2), (1, 3), (1, 4), (2, 3), (2, 4), (3, 4)}
    assert result == expected

    solution = Solution()
    assert solution.combine(1, 1) == [[1]]

    print("All tests passed.")
