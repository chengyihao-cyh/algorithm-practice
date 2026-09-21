"""LeetCode 27. Remove Element
https://leetcode.cn/problems/remove-element/
"""

from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        slow = 0
        for fast in range(len(nums)):
            if nums[fast] != val:
                nums[slow] = nums[fast]
                slow += 1

        return slow


if __name__ == "__main__":
    solution = Solution()

    nums1 = [3, 2, 2, 3]
    k1 = solution.removeElement(nums1, 3)
    assert k1 == 2
    assert nums1[:k1] == [2, 2]

    nums2 = [0, 1, 2, 2, 3, 0, 4, 2]
    k2 = solution.removeElement(nums2, 2)
    assert k2 == 5
    assert sorted(nums2[:k2]) == [0, 0, 1, 3, 4]

    print("All tests passed.")
