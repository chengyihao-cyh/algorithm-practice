"""LeetCode 349. Intersection of Two Arrays
https://leetcode.cn/problems/intersection-of-two-arrays/
"""

from typing import List


class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert sorted(solution.intersection([1, 2, 2, 1], [2, 2])) == [2]
    assert sorted(solution.intersection([4, 9, 5], [9, 4, 9, 8, 4])) == [4, 9]
    print("All tests passed.")
