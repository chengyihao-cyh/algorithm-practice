"""LeetCode 347. Top K Frequent Elements
https://leetcode.cn/problems/top-k-frequent-elements/
"""

from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        pass


if __name__ == "__main__":
    solution = Solution()
    result1 = solution.topKFrequent([1, 1, 1, 2, 2, 3], 2)
    assert set(result1) == {1, 2}

    result2 = solution.topKFrequent([1], 1)
    assert result2 == [1]

    print("All tests passed.")
