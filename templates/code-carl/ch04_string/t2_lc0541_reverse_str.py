"""LeetCode 541. Reverse String II
https://leetcode.cn/problems/reverse-string-ii/
"""


class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.reverseStr("abcdefg", 2) == "bacdfeg"
    assert solution.reverseStr("abcd", 2) == "bacd"
    print("All tests passed.")
