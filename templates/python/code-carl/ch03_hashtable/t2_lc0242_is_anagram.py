"""LeetCode 242. Valid Anagram
https://leetcode.cn/problems/valid-anagram/
"""


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.isAnagram("anagram", "nagaram") is True
    assert solution.isAnagram("rat", "car") is False
    print("All tests passed.")
