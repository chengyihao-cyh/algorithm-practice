"""LeetCode 738. Monotone Increasing Digits
https://leetcode.cn/problems/monotone-increasing-digits/
"""


class Solution:
    def monotoneIncreasingDigits(self, n: int) -> int:
        n_list = list(str(n))
        begin = len(n_list)

        for i in range(len(n_list) - 1, 0, -1):
            if n_list[i] < n_list[i - 1]:
                n_list[i - 1] = chr(ord(n_list[i - 1]) - 1)
                begin = i
        for i in range(begin, len(n_list)):
            n_list[i] = '9'

        return int(''.join(n_list))


if __name__ == "__main__":
    solution = Solution()
    assert solution.monotoneIncreasingDigits(10) == 9
    assert solution.monotoneIncreasingDigits(1234) == 1234
    assert solution.monotoneIncreasingDigits(332) == 299
    print("All tests passed.")
