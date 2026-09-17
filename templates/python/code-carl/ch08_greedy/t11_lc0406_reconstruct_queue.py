"""LeetCode 406. Queue Reconstruction by Height
https://leetcode.cn/problems/queue-reconstruction-by-height/
"""

from typing import List


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.reconstructQueue([[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]) == [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
    assert solution.reconstructQueue([[6, 0], [5, 0], [4, 0], [3, 2], [2, 2], [1, 4]]) == [[4, 0], [5, 0], [2, 2], [3, 2], [1, 4], [6, 0]]
    print("All tests passed.")
