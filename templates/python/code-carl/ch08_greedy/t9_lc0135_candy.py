"""LeetCode 135. Candy
https://leetcode.cn/problems/candy/
"""

from typing import List


class Solution:
    def candy(self, ratings: List[int]) -> int:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.candy([1, 0, 2]) == 5
    assert solution.candy([1, 2, 2]) == 4
    print("All tests passed.")
