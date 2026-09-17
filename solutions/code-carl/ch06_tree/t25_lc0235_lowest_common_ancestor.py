"""LeetCode 235. Lowest Common Ancestor of a Binary Search Tree
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def lowestCommonAncestor(
            self, root: Optional[TreeNode], p: Optional[TreeNode], q: Optional[TreeNode]
    ) -> Optional[TreeNode]:
        min_val, max_val = min(p.val, q.val), max(p.val, q.val)

        while root:
            if root.val > max_val:
                root = root.left
            elif root.val < min_val:
                root = root.right
            else:
                return root

        return None


if __name__ == "__main__":
    solution = Solution()

    node0 = TreeNode(0)
    node3 = TreeNode(3)
    node5 = TreeNode(5)
    node4 = TreeNode(4, node3, node5)
    node2 = TreeNode(2, node0, node4)
    node7 = TreeNode(7)
    node9 = TreeNode(9)
    node8 = TreeNode(8, node7, node9)
    root = TreeNode(6, node2, node8)

    assert solution.lowestCommonAncestor(root, node2, node8) is root
    assert solution.lowestCommonAncestor(root, node2, node4) is node2

    print("All tests passed.")
