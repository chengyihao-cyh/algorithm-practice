"""LeetCode 704. Binary Search
https://leetcode.cn/problems/binary-search/
"""

from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.search([-1, 0, 3, 5, 9, 12], 9) == 4
    assert solution.search([-1, 0, 3, 5, 9, 12], 2) == -1
    print("All tests passed.")
