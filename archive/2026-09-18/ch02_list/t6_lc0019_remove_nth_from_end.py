"""LeetCode 19. Remove Nth Node From End of List
https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
"""

from typing import Optional

from list_node import ListNode


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy_head = ListNode(-1, head)
        slow, fast = dummy_head, dummy_head

        for _ in range(n):
            fast = fast.next
        while fast.next:
            slow = slow.next
            fast = fast.next
        slow.next = slow.next.next

        return dummy_head.next


if __name__ == "__main__":
    from list_utils import build_list, to_list

    solution = Solution()
    assert to_list(solution.removeNthFromEnd(build_list([1, 2, 3, 4, 5]), 2)) == [1, 2, 3, 5]
    assert to_list(solution.removeNthFromEnd(build_list([1]), 1)) == []
    assert to_list(solution.removeNthFromEnd(build_list([1, 2]), 1)) == [1]
    print("All tests passed.")
