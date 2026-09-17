"""LeetCode 383. Ransom Note
https://leetcode.cn/problems/ransom-note/
"""


class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.canConstruct("a", "b") is False
    assert solution.canConstruct("aa", "aab") is True
    print("All tests passed.")
