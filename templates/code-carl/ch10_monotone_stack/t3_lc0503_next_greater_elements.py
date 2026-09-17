"""LeetCode 503. Next Greater Element II
https://leetcode.cn/problems/next-greater-element-ii/
"""

from typing import List


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.nextGreaterElements([1, 2, 1]) == [2, -1, 2]
    assert solution.nextGreaterElements([1, 2, 3, 4, 3]) == [2, 3, 4, -1, 4]
    print("All tests passed.")
