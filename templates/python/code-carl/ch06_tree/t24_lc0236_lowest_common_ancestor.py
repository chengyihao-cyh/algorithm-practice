"""LeetCode 236. Lowest Common Ancestor of a Binary Tree
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def lowestCommonAncestor(
        self, root: Optional[TreeNode], p: Optional[TreeNode], q: Optional[TreeNode]
    ) -> Optional[TreeNode]:
        pass


if __name__ == "__main__":

    node7 = TreeNode(7)
    node4 = TreeNode(4)
    node6 = TreeNode(6)
    node2 = TreeNode(2, node7, node4)
    node5 = TreeNode(5, node6, node2)
    node0 = TreeNode(0)
    node8 = TreeNode(8)
    node1 = TreeNode(1, node0, node8)
    root = TreeNode(3, node5, node1)

    solution = Solution()
    assert solution.lowestCommonAncestor(root, node5, node1) is root
    solution = Solution()
    assert solution.lowestCommonAncestor(root, node5, node4) is node5

    small_left = TreeNode(2)
    small_root = TreeNode(1, small_left)
    solution = Solution()
    assert (
        solution.lowestCommonAncestor(small_root, small_root, small_left) is small_root
    )

    print("All tests passed.")
