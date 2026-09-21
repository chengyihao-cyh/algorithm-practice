"""LeetCode 383. Ransom Note
https://leetcode.cn/problems/ransom-note/
"""
from collections import Counter


class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        return Counter(magazine) >= Counter(ransomNote)


if __name__ == "__main__":
    solution = Solution()
    assert solution.canConstruct("a", "b") is False
    assert solution.canConstruct("aa", "aab") is True
    print("All tests passed.")
