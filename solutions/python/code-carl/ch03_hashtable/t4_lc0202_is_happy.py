"""LeetCode 202. Happy Number
https://leetcode.cn/problems/happy-number/
"""


class Solution:
    def isHappy(self, n: int) -> bool:
        st = set()
        curr = n
        while curr != 1 and curr not in st:
            st.add(curr)
            curr = self.nextNum(curr)

        return curr == 1

    def nextNum(self, n: int) -> int:
        num = 0
        while n > 0:
            num += (n % 10) ** 2
            n //= 10
        return num


if __name__ == "__main__":
    solution = Solution()
    assert solution.isHappy(19) is True
    assert solution.isHappy(2) is False
    print("All tests passed.")
