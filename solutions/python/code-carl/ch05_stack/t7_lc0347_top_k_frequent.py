"""LeetCode 347. Top K Frequent Elements
https://leetcode.cn/problems/top-k-frequent-elements/
"""
import heapq
from collections import Counter
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        cnt = Counter(nums)
        heap = []

        for num, freq in cnt.items():
            if len(heap) < k:
                heapq.heappush(heap, (freq, num))
            else:
                if freq > heap[0][0]:
                    heapq.heapreplace(heap, (freq, num))

        return [num for _, num in heap]


if __name__ == "__main__":
    solution = Solution()
    result1 = solution.topKFrequent([1, 1, 1, 2, 2, 3], 2)
    assert set(result1) == {1, 2}

    result2 = solution.topKFrequent([1], 1)
    assert result2 == [1]

    print("All tests passed.")
