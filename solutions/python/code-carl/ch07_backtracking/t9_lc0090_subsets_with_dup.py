"""LeetCode 90. Subsets II
https://leetcode.cn/problems/subsets-ii/
"""

from typing import List


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        path: List[int] = []
        ans: List[List[int]] = []
        used: List[bool] = [False] * len(nums)

        def backtracking(nums: List[int], start_idx: int) -> None:
            ans.append(path[:])
            if start_idx == len(nums):
                return

            for i in range(start_idx, len(nums)):
                if i > 0 and nums[i] == nums[i - 1] and not used[i - 1]:
                    continue
                path.append(nums[i])
                used[i] = True
                backtracking(nums, i + 1)
                path.pop()
                used[i] = False

        nums.sort()
        backtracking(nums, 0)
        return ans


if __name__ == "__main__":
    solution = Solution()
    result = {tuple(x) for x in solution.subsetsWithDup([1, 2, 2])}
    expected = {(), (1,), (2,), (1, 2), (2, 2), (1, 2, 2)}
    assert result == expected

    solution = Solution()
    result = {tuple(x) for x in solution.subsetsWithDup([0])}
    assert result == {(), (0,)}

    print("All tests passed.")
