"""LeetCode 763. Partition Labels
https://leetcode.cn/problems/partition-labels/
"""

from typing import List


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.partitionLabels('ababcbacadefegdehijhklij') == [9, 7, 8]
    assert solution.partitionLabels('eccbbbbdec') == [10]
    print("All tests passed.")
