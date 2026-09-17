"""LeetCode 455. Assign Cookies
https://leetcode.cn/problems/assign-cookies/
"""

from typing import List


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.findContentChildren([1, 2, 3], [1, 1]) == 1
    assert solution.findContentChildren([1, 2], [1, 2, 3]) == 2
    print("All tests passed.")
