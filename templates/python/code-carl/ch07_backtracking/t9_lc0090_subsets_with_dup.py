"""LeetCode 90. Subsets II
https://leetcode.cn/problems/subsets-ii/
"""

from typing import List


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        pass


if __name__ == "__main__":
    solution = Solution()
    result = {tuple(x) for x in solution.subsetsWithDup([1, 2, 2])}
    expected = {(), (1,), (2,), (1, 2), (2, 2), (1, 2, 2)}
    assert result == expected

    solution = Solution()
    result = {tuple(x) for x in solution.subsetsWithDup([0])}
    assert result == {(), (0,)}

    print("All tests passed.")
