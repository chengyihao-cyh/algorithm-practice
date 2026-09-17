"""LeetCode 47. Permutations II
https://leetcode.cn/problems/permutations-ii/
"""

from typing import List


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        pass


if __name__ == "__main__":
    solution = Solution()
    result = {tuple(x) for x in solution.permuteUnique([1, 1, 2])}
    expected = {(1, 1, 2), (1, 2, 1), (2, 1, 1)}
    assert result == expected

    solution = Solution()
    result = {tuple(x) for x in solution.permuteUnique([1, 2, 3])}
    expected = {
        (1, 2, 3),
        (1, 3, 2),
        (2, 1, 3),
        (2, 3, 1),
        (3, 1, 2),
        (3, 2, 1),
    }
    assert result == expected

    print("All tests passed.")
