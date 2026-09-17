"""LeetCode 239. Sliding Window Maximum
https://leetcode.cn/problems/sliding-window-maximum/
"""

from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.maxSlidingWindow([1, 3, -1, -3, 5, 3, 6, 7], 3) == [3, 3, 5, 5, 6, 7]
    assert solution.maxSlidingWindow([1], 1) == [1]
    print("All tests passed.")
