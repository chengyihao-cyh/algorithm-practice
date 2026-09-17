"""LeetCode 51. N-Queens
https://leetcode.cn/problems/n-queens/
"""

from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        pass


if __name__ == "__main__":
    solution = Solution()
    result = {tuple(x) for x in solution.solveNQueens(4)}
    expected = {
        (".Q..", "...Q", "Q...", "..Q."),
        ("..Q.", "Q...", "...Q", ".Q.."),
    }
    assert result == expected

    solution = Solution()
    assert solution.solveNQueens(1) == [["Q"]]

    print("All tests passed.")
