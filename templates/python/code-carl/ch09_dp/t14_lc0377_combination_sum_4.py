"""LeetCode 377. Combination Sum IV
https://leetcode.cn/problems/combination-sum-iv/
"""

from typing import List


class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.combinationSum4([1, 2, 3], 4) == 7
    assert solution.combinationSum4([9], 3) == 0
    print("All tests passed.")
