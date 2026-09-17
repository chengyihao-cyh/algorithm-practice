"""LeetCode 738. Monotone Increasing Digits
https://leetcode.cn/problems/monotone-increasing-digits/
"""


class Solution:
    def monotoneIncreasingDigits(self, n: int) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.monotoneIncreasingDigits(10) == 9
    assert solution.monotoneIncreasingDigits(1234) == 1234
    assert solution.monotoneIncreasingDigits(332) == 299
    print("All tests passed.")
