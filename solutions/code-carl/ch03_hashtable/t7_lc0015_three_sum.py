"""LeetCode 15. 3Sum
https://leetcode.cn/problems/3sum/
"""

from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans: List[List[int]] = []
        for i in range(0, len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            l, r = i + 1, len(nums) - 1
            while l < r:
                curr_sum = nums[i] + nums[l] + nums[r]
                if curr_sum < 0:
                    l += 1
                elif curr_sum > 0:
                    r -= 1
                else:
                    ans.append([nums[i], nums[l], nums[r]])
                    while l < r and nums[l + 1] == nums[l]:
                        l += 1
                    while l < r and nums[r - 1] == nums[r]:
                        r -= 1
                    l += 1
                    r -= 1
        return ans


if __name__ == "__main__":
    solution = Solution()

    print(solution.threeSum([-1, 0, 1, 2, -1, -4]))

    result1 = sorted([sorted(item) for item in solution.threeSum([-1, 0, 1, 2, -1, -4])])
    expected1 = sorted([[-1, -1, 2], [-1, 0, 1]])
    assert result1 == expected1

    result2 = solution.threeSum([0, 1, 1])
    assert result2 == []

    result3 = solution.threeSum([0, 0, 0])
    assert sorted([sorted(item) for item in result3]) == [[0, 0, 0]]

    print("All tests passed.")
