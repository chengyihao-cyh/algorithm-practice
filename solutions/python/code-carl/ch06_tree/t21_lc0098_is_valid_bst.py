"""LeetCode 98. Validate Binary Search Tree
https://leetcode.cn/problems/validate-binary-search-tree/
"""
import sys
from typing import Optional

from tree_node import TreeNode


class Solution:
    pre_num: int = - sys.maxsize - 1

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        if not self.isValidBST(root.left):
            return False

        if root.val <= self.pre_num:
            return False
        self.pre_num = root.val

        return self.isValidBST(root.right)


if __name__ == "__main__":
    solution = Solution()
    root1 = TreeNode(2, TreeNode(1), TreeNode(3))
    assert solution.isValidBST(root1) is True

    solution = Solution()
    root2 = TreeNode(5, TreeNode(1), TreeNode(4, TreeNode(3), TreeNode(6)))
    assert solution.isValidBST(root2) is False

    print("All tests passed.")
