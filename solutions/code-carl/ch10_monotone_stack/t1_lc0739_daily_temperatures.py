"""LeetCode 739. Daily Temperatures
https://leetcode.cn/problems/daily-temperatures/
"""

from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack: List[int] = []
        ans: List[int] = [0] * len(temperatures)

        for idx, num in enumerate(temperatures):
            while stack and num > temperatures[stack[-1]]:
                popIdx = stack.pop()
                ans[popIdx] = idx - popIdx
            stack.append(idx)

        return ans


if __name__ == "__main__":
    solution = Solution()
    assert solution.dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]) == [1, 1, 4, 2, 1, 1, 0, 0]

    assert solution.dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]) == [1, 1, 4, 2, 1, 1, 0, 0]

    print("All tests passed.")
