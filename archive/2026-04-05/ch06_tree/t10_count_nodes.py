"""LeetCode 222. Count Complete Tree Nodes
https://leetcode.cn/problems/count-complete-tree-nodes/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        left, right, depth = root, root, 0
        while not left and not right:
            left = left.left
            right = right.right
            depth += 1

        if not left and not right:
            return 2 ** depth - 1
        else:
            return self.countNodes(root.left) + self.countNodes(root.right) + 1

if __name__ == "__main__":
    solution = Solution()
    root = TreeNode(
        1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3, TreeNode(6), None)
    )
    assert solution.countNodes(root) == 6
    assert solution.countNodes(None) == 0
    print("All tests passed.")
