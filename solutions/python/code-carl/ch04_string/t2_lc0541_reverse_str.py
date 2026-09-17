"""LeetCode 541. Reverse String II
https://leetcode.cn/problems/reverse-string-ii/
"""


class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        chars = list(s)
        for i in range(0, len(s), 2 * k):
            chars[i:i + k] = chars[i:i + k][::-1]
        return "".join(chars)


if __name__ == "__main__":
    solution = Solution()
    assert solution.reverseStr("abcdefg", 2) == "bacdfeg"
    assert solution.reverseStr("abcd", 2) == "bacd"
    print("All tests passed.")
