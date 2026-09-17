"""LeetCode 18. 4Sum
https://leetcode.cn/problems/4sum/
"""

from typing import List


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        ans: List[List[int]] = []
        for i in range(0, len(nums) - 3):
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            for j in range(i + 1, len(nums) - 2):
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue

                l, r = j + 1, len(nums) - 1
                while l < r:
                    curr_sum = nums[i] + nums[j] + nums[l] + nums[r]
                    if curr_sum < target:
                        l += 1
                    elif curr_sum > target:
                        r -= 1
                    else:
                        ans.append([nums[i], nums[j], nums[l], nums[r]])
                        while l < r and nums[l + 1] == nums[l]:
                            l += 1
                        while l < r and nums[r - 1] == nums[r]:
                            r -= 1
                        l += 1
                        r -= 1
        return ans


if __name__ == "__main__":
    solution = Solution()

    result1 = sorted([sorted(item) for item in solution.fourSum([1, 0, -1, 0, -2, 2], 0)])
    expected1 = sorted([[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]])
    assert result1 == expected1

    result2 = sorted([sorted(item) for item in solution.fourSum([2, 2, 2, 2, 2], 8)])
    assert result2 == [[2, 2, 2, 2]]

    print("All tests passed.")
