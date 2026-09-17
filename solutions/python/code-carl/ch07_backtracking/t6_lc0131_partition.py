"""LeetCode 131. Palindrome Partitioning
https://leetcode.cn/problems/palindrome-partitioning/
"""

from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        path: List[str] = []
        ans: List[List[str]] = []

        def backtracking(s: str, start_idx: int) -> None:
            if start_idx == len(s):
                ans.append(path[:])
                return

            for i in range(start_idx, len(s)):
                if not is_valid(s, start_idx, i):
                    continue
                path.append(s[start_idx:i + 1])
                backtracking(s, i + 1)
                path.pop()

        def is_valid(s: str, l: int, r: int) -> bool:
            if l == r:
                return True
            while l < r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1
            return True

        backtracking(s, 0)
        return ans


if __name__ == "__main__":
    solution = Solution()
    result = sorted(tuple(x) for x in solution.partition("aab"))
    expected = sorted([("a", "a", "b"), ("aa", "b")])
    assert result == expected

    solution = Solution()
    assert solution.partition("a") == [["a"]]

    print("All tests passed.")
