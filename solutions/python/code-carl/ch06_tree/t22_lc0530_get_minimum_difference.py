"""LeetCode 530. Minimum Absolute Difference in BST
https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
"""
import sys
from typing import Optional

from tree_node import TreeNode


class Solution:
    pre_num = -sys.maxsize - 1
    min_diff = sys.maxsize

    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        def traversal(root: Optional[TreeNode]) -> None:
            if not root:
                return
            traversal(root.left)
            if self.pre_num != -sys.maxsize - 1:
                self.min_diff = min(self.min_diff, root.val - self.pre_num)
            self.pre_num = root.val
            traversal(root.right)

        traversal(root)
        return self.min_diff if self.min_diff != sys.maxsize else -1


if __name__ == "__main__":
    solution = Solution()
    root1 = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(6))
    assert solution.getMinimumDifference(root1) == 1

    solution = Solution()
    root2 = TreeNode(1, TreeNode(0), TreeNode(48, TreeNode(12), TreeNode(49)))
    assert solution.getMinimumDifference(root2) == 1

    print("All tests passed.")
