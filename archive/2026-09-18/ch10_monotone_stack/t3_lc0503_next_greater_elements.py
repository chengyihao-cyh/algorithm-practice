"""LeetCode 503. Next Greater Element II
https://leetcode.cn/problems/next-greater-element-ii/
"""

from typing import List


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        ans: List[int] = [-1] * len(nums)
        stack: List[int] = []

        for i in range(2 * len(nums)):
            while stack and nums[stack[-1]] < nums[i % len(nums)]:
                ans[stack.pop()] = nums[i % len(nums)]
            stack.append(i % len(nums))

        return ans


if __name__ == "__main__":
    solution = Solution()
    assert solution.nextGreaterElements([1, 2, 1]) == [2, -1, 2]
    assert solution.nextGreaterElements([1, 2, 3, 4, 3]) == [2, 3, 4, -1, 4]
    print("All tests passed.")
