"""LeetCode 78. Subsets
https://leetcode.cn/problems/subsets/
"""

from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        path: List[int] = []
        ans: List[List[int]] = []

        def backtracking(nums: List[int], start_idx: int) -> None:
            ans.append(path[:])
            if start_idx == len(nums):
                return
            for i in range(start_idx, len(nums)):
                path.append(nums[i])
                backtracking(nums, i + 1)
                path.pop()

        backtracking(nums, 0)
        return ans


if __name__ == "__main__":
    solution = Solution()
    result = {tuple(x) for x in solution.subsets([1, 2, 3])}
    expected = {
        (),
        (1,),
        (2,),
        (3,),
        (1, 2),
        (1, 3),
        (2, 3),
        (1, 2, 3),
    }
    assert result == expected

    solution = Solution()
    result = {tuple(x) for x in solution.subsets([0])}
    assert result == {(), (0,)}

    print("All tests passed.")
