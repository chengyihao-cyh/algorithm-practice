"""LeetCode 110. Balanced Binary Tree
https://leetcode.cn/problems/balanced-binary-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        pass


if __name__ == "__main__":
    root1 = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
    solution = Solution()
    assert solution.isBalanced(root1) is True

    root2 = TreeNode(
        1, TreeNode(2, TreeNode(3, TreeNode(4), TreeNode(4)), TreeNode(3)), TreeNode(2)
    )
    solution = Solution()
    assert solution.isBalanced(root2) is False

    print("All tests passed.")
