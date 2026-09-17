"""LeetCode 15. 3Sum
https://leetcode.cn/problems/3sum/
"""

from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        pass


if __name__ == "__main__":
    solution = Solution()

    result1 = sorted([sorted(item) for item in solution.threeSum([-1, 0, 1, 2, -1, -4])])
    expected1 = sorted([[-1, -1, 2], [-1, 0, 1]])
    assert result1 == expected1

    result2 = solution.threeSum([0, 1, 1])
    assert result2 == []

    result3 = solution.threeSum([0, 0, 0])
    assert sorted([sorted(item) for item in result3]) == [[0, 0, 0]]

    print("All tests passed.")
