from typing import Iterable, List, Optional

from list_node import ListNode


def build_list(values: Iterable[int]) -> Optional[ListNode]:
    dummy = ListNode()
    cur = dummy
    for v in values:
        cur.next = ListNode(v)
        cur = cur.next
    return dummy.next


def to_list(head: Optional[ListNode]) -> List[int]:
    res: List[int] = []
    cur = head
    while cur:
        res.append(cur.val)
        cur = cur.next
    return res

