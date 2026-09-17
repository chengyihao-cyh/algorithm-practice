"""LeetCode 142. Linked List Cycle II
https://leetcode.cn/problems/linked-list-cycle-ii/
"""

from __future__ import annotations

from typing import Optional

from list_node import ListNode


class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        pass


if __name__ == "__main__":
    solution = Solution()

    node1 = ListNode(3)
    node2 = ListNode(2)
    node3 = ListNode(0)
    node4 = ListNode(-4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2
    assert solution.detectCycle(node1) is node2

    head = ListNode(1, ListNode(2))
    assert solution.detectCycle(head) is None

    print("All tests passed.")
