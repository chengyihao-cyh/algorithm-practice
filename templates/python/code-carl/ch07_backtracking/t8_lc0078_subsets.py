"""LeetCode 78. Subsets
https://leetcode.cn/problems/subsets/
"""

from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        pass


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
