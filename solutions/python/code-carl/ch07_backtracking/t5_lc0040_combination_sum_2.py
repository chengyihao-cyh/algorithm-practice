"""LeetCode 40. Combination Sum II
https://leetcode.cn/problems/combination-sum-ii/
"""

from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        path: List[int] = []
        ans: List[List[int]] = []
        used: List[bool] = [False] * len(candidates)

        def backtracking(nums: List[int], target: int, sum: int, start_idx: int) -> None:
            if sum == target:
                ans.append(path[:])
                return

            for i in range(start_idx, len(nums)):
                if sum > target:
                    break
                if i > 0 and nums[i] == nums[i - 1] and not used[i - 1]:
                    continue

                path.append(nums[i])
                used[i] = True
                backtracking(nums, target, sum + nums[i], i + 1)
                path.pop()
                used[i] = False

        if candidates:
            candidates.sort()
            backtracking(candidates, target, 0, 0)
        return ans


if __name__ == "__main__":
    solution = Solution()
    result = sorted(sorted(x) for x in solution.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))
    expected = sorted(sorted(x) for x in [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]])
    assert result == expected

    solution = Solution()
    result = sorted(sorted(x) for x in solution.combinationSum2([2, 5, 2, 1, 2], 5))
    expected = sorted(sorted(x) for x in [[1, 2, 2], [5]])
    assert result == expected

    print("All tests passed.")
