"""LeetCode 47. Permutations II
https://leetcode.cn/problems/permutations-ii/
"""

from typing import List


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        path: List[int] = []
        ans: List[List[int]] = []
        used: List[bool] = [False] * len(nums)

        def backtracking(nums: List[int]) -> None:
            if len(path) == len(nums):
                ans.append(path[:])
                return

            for i in range(0, len(nums)):
                if used[i] or i > 0 and nums[i] == nums[i - 1] and not used[i - 1]:
                    continue

                path.append(nums[i])
                used[i] = True
                backtracking(nums)
                path.pop()
                used[i] = False

        nums.sort()
        backtracking(nums)
        return ans


if __name__ == "__main__":
    solution = Solution()
    result = {tuple(x) for x in solution.permuteUnique([1, 1, 2])}

    expected = {(1, 1, 2), (1, 2, 1), (2, 1, 1)}
    assert result == expected

    solution = Solution()
    result = {tuple(x) for x in solution.permuteUnique([1, 2, 3])}
    expected = {
        (1, 2, 3),
        (1, 3, 2),
        (2, 1, 3),
        (2, 3, 1),
        (3, 1, 2),
        (3, 2, 1),
    }
    assert result == expected

    print("All tests passed.")
