"""LeetCode 207. Course Schedule
https://leetcode.cn/problems/course-schedule/
"""

from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.canFinish(2, [[1, 0]]) is True
    assert solution.canFinish(2, [[1, 0], [0, 1]]) is False
    print("All tests passed.")
