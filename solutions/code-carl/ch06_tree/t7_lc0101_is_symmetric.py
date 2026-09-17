"""LeetCode 101. Symmetric Tree
https://leetcode.cn/problems/symmetric-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        return self.compare(root.left, root.right)

    def compare(self, left: Optional[TreeNode], right: Optional[TreeNode]) -> bool:
        if not left and not right:
            return True
        elif not left or not right or left.val != right.val:
            return False
        else:
            return self.compare(left.right, right.left) and self.compare(left.left, right.right)


if __name__ == "__main__":
    solution = Solution()

    root1 = TreeNode(
        1, TreeNode(2, TreeNode(3), TreeNode(4)), TreeNode(2, TreeNode(4), TreeNode(3))
    )
    assert solution.isSymmetric(root1) is True

    root2 = TreeNode(1, TreeNode(2, None, TreeNode(3)), TreeNode(2, None, TreeNode(3)))
    assert solution.isSymmetric(root2) is False

    print("All tests passed.")
