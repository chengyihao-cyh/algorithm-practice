"""LeetCode 455. Assign Cookies
https://leetcode.cn/problems/assign-cookies/
"""

from typing import List


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        if not g or not s:
            return 0

        g.sort()
        s.sort()

        s_idx = len(s) - 1
        cnt = 0

        for g_idx, g_val in enumerate(g[::-1]):
            if s[s_idx] >= g_val:
                cnt += 1
                s_idx -= 1
                if s_idx < 0:
                    break

        return cnt


if __name__ == "__main__":
    solution = Solution()
    assert solution.findContentChildren([1, 2, 3], [1, 1]) == 1
    assert solution.findContentChildren([1, 2], [1, 2, 3]) == 2
    print("All tests passed.")
