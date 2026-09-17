"""LeetCode 763. Partition Labels
https://leetcode.cn/problems/partition-labels/
"""
from collections import defaultdict
from typing import List


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        dic = defaultdict(int)
        for i, ch in enumerate(s):
            dic[ch] = i

        ans: List[int] = []
        left, right = 0, 0
        for i, ch in enumerate(s):
            right = max(right, dic[ch])
            if right == i:
                ans.append(i - left + 1)
                left = i + 1

        return ans


if __name__ == "__main__":
    solution = Solution()
    assert solution.partitionLabels('ababcbacadefegdehijhklij') == [9, 7, 8]
    assert solution.partitionLabels('eccbbbbdec') == [10]
    print("All tests passed.")
