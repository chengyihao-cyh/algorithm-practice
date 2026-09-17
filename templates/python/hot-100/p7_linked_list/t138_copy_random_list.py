"""LeetCode 138. Copy List with Random Pointer
https://leetcode.cn/problems/copy-list-with-random-pointer/
"""

from __future__ import annotations

from typing import Optional


class Node:
    def __init__(
        self,
        val: int = 0,
        next: Optional[Node] = None,
        random: Optional[Node] = None,
    ):
        self.val = val
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: Optional[Node]) -> Optional[Node]:
        pass
