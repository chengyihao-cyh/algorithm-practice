"""LeetCode 135. Candy
https://leetcode.cn/problems/candy/
"""

from typing import List


class Solution:
    def candy(self, ratings: List[int]) -> int:
        ans: List[int] = [1] * len(ratings)

        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]:
                ans[i] = max(ans[i], ans[i - 1] + 1)
        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                ans[i] = max(ans[i], ans[i + 1] + 1)

        return sum(ans)


if __name__ == "__main__":
    solution = Solution()
    assert solution.candy([1, 0, 2]) == 5
    assert solution.candy([1, 2, 2]) == 4
    print("All tests passed.")
