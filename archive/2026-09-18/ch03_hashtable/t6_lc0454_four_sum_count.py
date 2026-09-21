"""LeetCode 454. 4Sum II
https://leetcode.cn/problems/4sum-ii/
"""
from collections import defaultdict
from typing import List


class Solution:
    def fourSumCount(
            self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]
    ) -> int:
        freq: defaultdict[int, int] = defaultdict(int)
        cnt = 0
        for n1 in nums1:
            for n2 in nums2:
                freq[n1 + n2] += 1
        for n3 in nums3:
            for n4 in nums4:
                cnt += freq[-n3 - n4]

        return cnt


if __name__ == "__main__":
    solution = Solution()
    assert solution.fourSumCount([1, 2], [-2, -1], [-1, 2], [0, 2]) == 2
    assert solution.fourSumCount([0], [0], [0], [0]) == 1
    print("All tests passed.")
