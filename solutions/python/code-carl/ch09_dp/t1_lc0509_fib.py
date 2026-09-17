"""LeetCode 509. Fibonacci Number
https://leetcode.cn/problems/fibonacci-number/
"""


class Solution:
    def fib(self, n: int) -> int:
        if n <= 1:
            return n

        pre, curr = 0, 1
        for i in range(2, n + 1):
            pre, curr = curr, pre + curr

        return curr

if __name__ == "__main__":
    solution = Solution()
    assert solution.fib(2) == 1
    assert solution.fib(3) == 2
    assert solution.fib(4) == 3
    print("All tests passed.")
