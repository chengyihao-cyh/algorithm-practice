"""LeetCode 206. Reverse Linked List
https://leetcode.cn/problems/reverse-linked-list/
"""

from typing import Optional

from list_node import ListNode


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        pre, curr = None, head
        while curr:
            tmp = curr.next
            curr.next = pre
            pre = curr
            curr = tmp

        return pre


if __name__ == "__main__":
    from list_utils import build_list, to_list

    solution = Solution()
    assert to_list(solution.reverseList(build_list([1, 2, 3, 4, 5]))) == [5, 4, 3, 2, 1]
    assert solution.reverseList(None) is None
    print("All tests passed.")
