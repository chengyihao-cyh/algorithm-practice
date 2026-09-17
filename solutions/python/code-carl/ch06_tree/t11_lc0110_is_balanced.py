"""LeetCode 110. Balanced Binary Tree
https://leetcode.cn/problems/balanced-binary-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        left =  self.getHeight(root.left)
        right = self.getHeight(root.right)
        return left != -1 and right != -1 and abs(left - right) <= 1

    def getHeight(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        left = self.getHeight(root.left)
        if left == -1:
            return -1

        right = self.getHeight(root.right)
        if right == -1:
            return -1

        if abs(left - right) > 1:
            return -1

        return max(left, right) + 1


if __name__ == "__main__":
    solution = Solution()
    root1 = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
    assert solution.isBalanced(root1) is True

    root2 = TreeNode(
        1, TreeNode(2, TreeNode(3, TreeNode(4), TreeNode(4)), TreeNode(3)), TreeNode(2)
    )
    assert solution.isBalanced(root2) is False

    print("All tests passed.")
