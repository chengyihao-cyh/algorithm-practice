"""LeetCode 40. Combination Sum II
https://leetcode.cn/problems/combination-sum-ii/
"""

from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        pass


if __name__ == "__main__":
    solution = Solution()
    result = sorted(sorted(x) for x in solution.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))
    expected = sorted(sorted(x) for x in [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]])
    assert result == expected

    solution = Solution()
    result = sorted(sorted(x) for x in solution.combinationSum2([2, 5, 2, 1, 2], 5))
    expected = sorted(sorted(x) for x in [[1, 2, 2], [5]])
    assert result == expected

    print("All tests passed.")
