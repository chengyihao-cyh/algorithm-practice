"""LeetCode 70. Climbing Stairs
https://leetcode.cn/problems/climbing-stairs/
"""


class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 1:
            return 1

        pre, curr = 1, 1
        for i in range(2, n + 1):
            pre, curr = curr, pre + curr

        return curr

if __name__ == "__main__":
    solution = Solution()
    assert solution.climbStairs(2) == 2
    assert solution.climbStairs(3) == 3
    print("All tests passed.")
