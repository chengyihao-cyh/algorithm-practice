"""LeetCode 222. Count Complete Tree Nodes
https://leetcode.cn/problems/count-complete-tree-nodes/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        pass


if __name__ == "__main__":
    root = TreeNode(
        1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3, TreeNode(6), None)
    )
    solution = Solution()
    assert solution.countNodes(root) == 6
    solution = Solution()
    assert solution.countNodes(None) == 0
    print("All tests passed.")
