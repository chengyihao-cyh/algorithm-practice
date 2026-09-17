"""LeetCode 46. Permutations
https://leetcode.cn/problems/permutations/
"""

from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        pass


if __name__ == "__main__":
    solution = Solution()
    result = {tuple(x) for x in solution.permute([1, 2, 3])}
    expected = {
        (1, 2, 3),
        (1, 3, 2),
        (2, 1, 3),
        (2, 3, 1),
        (3, 1, 2),
        (3, 2, 1),
    }
    assert result == expected

    solution = Solution()
    result = {tuple(x) for x in solution.permute([0, 1])}
    assert result == {(0, 1), (1, 0)}

    solution = Solution()
    assert solution.permute([1]) == [[1]]

    print("All tests passed.")
