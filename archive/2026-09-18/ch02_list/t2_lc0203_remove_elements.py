"""LeetCode 203. Remove Linked List Elements
https://leetcode.cn/problems/remove-linked-list-elements/
"""

from typing import Optional

from list_node import ListNode


class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        dummy_head = ListNode(-1, head)
        curr = dummy_head
        while curr.next:
            if curr.next.val != val:
                curr = curr.next
            else:
                curr.next = curr.next.next

        return dummy_head.next


if __name__ == "__main__":
    from list_utils import build_list, to_list

    solution = Solution()
    head1 = build_list([1, 2, 6, 3, 4, 5, 6])
    assert to_list(solution.removeElements(head1, 6)) == [1, 2, 3, 4, 5]
    assert solution.removeElements(None, 1) is None
    print("All tests passed.")
