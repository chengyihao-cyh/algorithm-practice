"""LeetCode 56. Merge Intervals
https://leetcode.cn/problems/merge-intervals/
"""

from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.merge([[1, 3], [2, 6], [8, 10], [15, 18]]) == [[1, 6], [8, 10], [15, 18]]
    assert solution.merge([[1, 4], [4, 5]]) == [[1, 5]]
    assert solution.merge([[4, 7], [1, 4]]) == [[1, 7]]
    print("All tests passed.")
