"""LeetCode 216. Combination Sum III
https://leetcode.cn/problems/combination-sum-iii/
"""

from typing import List


class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        path: List[int] = []
        ans: List[List[int]] = []

        def backtracking(k: int, n: int, start_idx: int, sum: int) -> None:
            if sum > n:
                return
            if len(path) == k:
                if sum == n:
                    ans.append(path[:])
                return

            for i in range(start_idx, 11 - k + len(path)):
                path.append(i)
                backtracking(k, n, i + 1, sum + i)
                path.pop()

        backtracking(k, n, 1, 0)
        return ans


if __name__ == "__main__":
    solution = Solution()
    assert solution.combinationSum3(3, 7) == [[1, 2, 4]]

    solution = Solution()
    result = {tuple(x) for x in solution.combinationSum3(3, 9)}
    expected = {(1, 2, 6), (1, 3, 5), (2, 3, 4)}
    assert result == expected

    solution = Solution()
    assert solution.combinationSum3(4, 1) == []

    print("All tests passed.")
