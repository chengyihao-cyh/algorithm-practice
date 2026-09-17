"""LeetCode 131. Palindrome Partitioning
https://leetcode.cn/problems/palindrome-partitioning/
"""

from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        pass


if __name__ == "__main__":
    solution = Solution()
    result = sorted(tuple(x) for x in solution.partition("aab"))
    expected = sorted([("a", "a", "b"), ("aa", "b")])
    assert result == expected

    solution = Solution()
    assert solution.partition("a") == [["a"]]

    print("All tests passed.")
