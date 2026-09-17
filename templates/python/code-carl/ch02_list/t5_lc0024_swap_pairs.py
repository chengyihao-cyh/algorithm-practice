"""LeetCode 24. Swap Nodes in Pairs
https://leetcode.cn/problems/swap-nodes-in-pairs/
"""

from typing import Optional

from list_node import ListNode


class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        pass


if __name__ == "__main__":
    from list_utils import build_list, to_list

    solution = Solution()
    assert to_list(solution.swapPairs(build_list([1, 2, 3, 4]))) == [2, 1, 4, 3]
    assert to_list(solution.swapPairs(build_list([1]))) == [1]
    print("All tests passed.")
