"""LeetCode 46. Permutations
https://leetcode.cn/problems/permutations/
"""

from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        path: List[int] = []
        ans: List[List[int]] = []
        used: List[bool] = [False] * len(nums)

        def backtracking(nums: List[int]) -> None:
            if len(path) == len(nums):
                ans.append(path[:])
                return

            for i, num in enumerate(nums):
                if used[i]:
                    continue

                path.append(num)
                used[i] = True
                backtracking(nums)
                path.pop()
                used[i] = False

        backtracking(nums)
        return ans


if __name__ == "__main__":
    solution = Solution()
    result = {tuple(x) for x in solution.permute([1, 2, 3])}
    expected = {
        (1, 2, 3),
        (1, 3, 2),
        (2, 1, 3),
        (2, 3, 1),
        (3, 1, 2),
        (3, 2, 1),
    }
    assert result == expected

    solution = Solution()
    result = {tuple(x) for x in solution.permute([0, 1])}
    assert result == {(0, 1), (1, 0)}

    solution = Solution()
    assert solution.permute([1]) == [[1]]

    print("All tests passed.")
