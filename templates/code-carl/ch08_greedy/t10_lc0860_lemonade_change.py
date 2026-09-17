"""LeetCode 860. Lemonade Change
https://leetcode.cn/problems/lemonade-change/
"""

from typing import List


class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.lemonadeChange([5, 5, 5, 10, 20]) == True
    assert solution.lemonadeChange([5, 5, 10, 10, 20]) == False
    print("All tests passed.")
