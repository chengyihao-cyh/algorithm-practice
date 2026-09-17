"""LeetCode 383. Ransom Note
https://leetcode.cn/problems/ransom-note/
"""
from typing import Counter


class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        return Counter(ransomNote) <= Counter(magazine)


if __name__ == "__main__":
    solution = Solution()
    assert solution.canConstruct("a", "b") is False
    assert solution.canConstruct("aa", "aab") is True
    print("All tests passed.")
