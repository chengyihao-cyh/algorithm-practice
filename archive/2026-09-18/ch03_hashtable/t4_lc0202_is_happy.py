"""LeetCode 202. Happy Number
https://leetcode.cn/problems/happy-number/
"""


class Solution:
    def isHappy(self, n: int) -> bool:
        def next_num(curr: int) -> int:
            sum = 0
            while curr > 0:
                sum += (curr % 10) ** 2
                curr //= 10
            return sum

        pre_set = set()
        while n not in pre_set and n != 1:
            pre_set.add(n)
            n = next_num(n)

        return n == 1


if __name__ == "__main__":
    solution = Solution()
    assert solution.isHappy(19) is True
    assert solution.isHappy(2) is False
    print("All tests passed.")
