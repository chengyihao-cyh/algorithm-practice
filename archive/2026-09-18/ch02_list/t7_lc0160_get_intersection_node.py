"""LeetCode 160. Intersection of Two Linked Lists
https://leetcode.cn/problems/intersection-of-two-linked-lists/
"""

from __future__ import annotations

from typing import Optional

from list_node import ListNode


class Solution:
    def getIntersectionNode(
            self, headA: Optional[ListNode], headB: Optional[ListNode]
    ) -> Optional[ListNode]:
        ptr_a, ptr_b = headA, headB
        len_a, len_b = 0, 0

        while ptr_a:
            len_a += 1
            ptr_a = ptr_a.next
        while ptr_b:
            len_b += 1
            ptr_b = ptr_b.next

        ptr_a, ptr_b = headA, headB
        if len_a < len_b:
            ptr_a, ptr_b = ptr_b, ptr_a
            len_a, len_b = len_b, len_a

        for _ in range(len_a - len_b):
            ptr_a = ptr_a.next

        while ptr_a and ptr_b:
            if ptr_a == ptr_b:
                return ptr_a
            ptr_a = ptr_a.next
            ptr_b = ptr_b.next
        return None


if __name__ == "__main__":
    solution = Solution()

    common = ListNode(8, ListNode(4, ListNode(5)))
    head_a = ListNode(4, ListNode(1, common))
    head_b = ListNode(5, ListNode(6, ListNode(1, common)))
    assert solution.getIntersectionNode(head_a, head_b) is common

    head_c = ListNode(2, ListNode(6, ListNode(4)))
    head_d = ListNode(1, ListNode(5))
    assert solution.getIntersectionNode(head_c, head_d) is None

    print("All tests passed.")
