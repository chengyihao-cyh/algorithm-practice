"""LeetCode 101. Symmetric Tree
https://leetcode.cn/problems/symmetric-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        pass


if __name__ == "__main__":

    root1 = TreeNode(
        1, TreeNode(2, TreeNode(3), TreeNode(4)), TreeNode(2, TreeNode(4), TreeNode(3))
    )
    solution = Solution()
    assert solution.isSymmetric(root1) is True

    root2 = TreeNode(1, TreeNode(2, None, TreeNode(3)), TreeNode(2, None, TreeNode(3)))
    solution = Solution()
    assert solution.isSymmetric(root2) is False

    print("All tests passed.")
