"""LeetCode 24. Swap Nodes in Pairs
https://leetcode.cn/problems/swap-nodes-in-pairs/
"""

from typing import Optional

from list_node import ListNode


class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummyHead = ListNode(-1, head)
        curr = dummyHead
        while curr.next is not None and curr.next.next is not None:
            pre, post, tmp = curr.next, curr.next.next, curr.next.next.next
            curr.next = post
            post.next = pre
            pre.next = tmp
            curr = pre

        return dummyHead.next


if __name__ == "__main__":
    from list_utils import build_list, to_list

    solution = Solution()
    assert to_list(solution.swapPairs(build_list([1, 2, 3, 4]))) == [2, 1, 4, 3]
    assert to_list(solution.swapPairs(build_list([1]))) == [1]
    print("All tests passed.")
