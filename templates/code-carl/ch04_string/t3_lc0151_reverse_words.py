"""LeetCode 151. Reverse Words in a String
https://leetcode.cn/problems/reverse-words-in-a-string/
"""


class Solution:
    def reverseWords(self, s: str) -> str:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.reverseWords("the sky is blue") == "blue is sky the"
    assert solution.reverseWords("  hello world  ") == "world hello"
    print("All tests passed.")
