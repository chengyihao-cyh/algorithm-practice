"""LeetCode 496. Next Greater Element I
https://leetcode.cn/problems/next-greater-element-i/
"""

from typing import List


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.nextGreaterElement([4, 1, 2], [1, 3, 4, 2]) == [-1, 3, -1]
    assert solution.nextGreaterElement([2, 4], [1, 2, 3, 4]) == [3, -1]
    print("All tests passed.")
