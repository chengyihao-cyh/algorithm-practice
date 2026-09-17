"""LeetCode 491. Non-decreasing Subsequences
https://leetcode.cn/problems/non-decreasing-subsequences/
"""

from typing import List


class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        path: List[int] = []
        ans: List[List[int]] = []

        def backtracking(nums: List[int], start_idx: int) -> None:
            if len(path) >= 2:
                ans.append(path[:])
            if start_idx == len(nums):
                return

            st = set()
            for i in range(start_idx, len(nums)):
                if path and nums[i] < path[-1] or nums[i] in st:
                    continue

                path.append(nums[i])
                st.add(nums[i])
                backtracking(nums, i + 1)
                path.pop()

        backtracking(nums, 0)
        return ans


if __name__ == "__main__":
    solution = Solution()
    result = {tuple(x) for x in solution.findSubsequences([4, 6, 7, 7])}
    expected = {(4, 6), (4, 7), (4, 6, 7), (4, 6, 7, 7), (4, 7, 7), (6, 7), (6, 7, 7), (7, 7)}
    assert result == expected

    solution = Solution()
    assert solution.findSubsequences([4, 4, 3, 2, 1]) == [[4, 4]]

    print("All tests passed.")
