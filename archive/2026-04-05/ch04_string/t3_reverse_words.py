"""c
https://leetcode.cn/problems/reverse-words-in-a-string/
"""


class Solution:
    def reverseWords(self, s: str) -> str:
        return " ".join(s.strip().split()[::-1])


if __name__ == "__main__":
    solution = Solution()
    assert solution.reverseWords("the sky is blue") == "blue is sky the"
    assert solution.reverseWords("  hello world  ") == "world hello"
    print("All tests passed.")
