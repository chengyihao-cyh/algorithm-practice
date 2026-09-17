"""LeetCode 513. Find Bottom Left Tree Value
https://leetcode.cn/problems/find-bottom-left-tree-value/
"""

from typing import Optional, Deque

from cytoolz.itertoolz import deque

from tree_node import TreeNode


class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        ans: int = 0
        queue: Deque[TreeNode] = deque([root])

        while queue:
            ans = queue[0].val
            for _ in range(len(queue)):
                curr = queue.popleft()
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)

        return ans


if __name__ == "__main__":
    solution = Solution()
    root1 = TreeNode(2, TreeNode(1), TreeNode(3))
    assert solution.findBottomLeftValue(root1) == 1

    root2 = TreeNode(
        1, TreeNode(2, TreeNode(4)), TreeNode(3, TreeNode(5, TreeNode(7)), TreeNode(6))
    )
    assert solution.findBottomLeftValue(root2) == 7

    print("All tests passed.")
