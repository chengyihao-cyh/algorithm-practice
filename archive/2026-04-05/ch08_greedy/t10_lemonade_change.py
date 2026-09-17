"""LeetCode 860. Lemonade Change
https://leetcode.cn/problems/lemonade-change/
"""

from typing import List


class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        if not bills:
            return True

        cnt_5 = 0
        cnt_10 = 0
        for bill in bills:
            if bill == 20:
                if cnt_10 > 0:
                    cnt_10 -= 1
                    cnt_5 -= 1
                else:
                    cnt_5 -= 3
            elif bill == 10:
                cnt_10 += 1
                cnt_5 -= 1
            else:
                cnt_5 += 1

            if cnt_5 < 0:
                return False

        return True


if __name__ == "__main__":
    solution = Solution()
    assert solution.lemonadeChange([5, 5, 5, 10, 20]) == True
    assert solution.lemonadeChange([5, 5, 10, 10, 20]) == False
    print("All tests passed.")
