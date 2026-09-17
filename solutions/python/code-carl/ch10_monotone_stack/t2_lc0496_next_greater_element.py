"""LeetCode 496. Next Greater Element I
https://leetcode.cn/problems/next-greater-element-i/
"""

from typing import List


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        dic = {n: i for i, n in enumerate(nums1)}
        ans = [-1] * len(nums1)

        stack: List[int] = []
        for i, n in enumerate(nums2):
            while stack and n > nums2[stack[-1]]:
                n_in_nums2 = nums2[stack.pop()]
                if n_in_nums2 in dic:
                    ans[dic[n_in_nums2]] = n
            stack.append(i)

        return ans


if __name__ == "__main__":
    solution = Solution()
    assert solution.nextGreaterElement([4, 1, 2], [1, 3, 4, 2]) == [-1, 3, -1]

    assert solution.nextGreaterElement([4, 1, 2], [1, 3, 4, 2]) == [-1, 3, -1]

    print("All tests passed.")
