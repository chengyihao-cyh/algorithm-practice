"""LeetCode 39. Combination Sum
https://leetcode.cn/problems/combination-sum/
"""

from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        pass


if __name__ == "__main__":
    solution = Solution()
    result = sorted(sorted(x) for x in solution.combinationSum([2, 3, 6, 7], 7))
    expected = sorted(sorted(x) for x in [[2, 2, 3], [7]])
    assert result == expected

    solution = Solution()
    result = sorted(sorted(x) for x in solution.combinationSum([2, 3, 5], 8))
    expected = sorted(sorted(x) for x in [[2, 2, 2, 2], [2, 3, 3], [3, 5]])
    assert result == expected

    solution = Solution()
    assert solution.combinationSum([2], 1) == []

    print("All tests passed.")
