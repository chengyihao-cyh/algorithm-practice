"""LeetCode 226. Invert Binary Tree
https://leetcode.cn/problems/invert-binary-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        pass


if __name__ == "__main__":
    root = TreeNode(
        4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(7, TreeNode(6), TreeNode(9))
    )
    solution = Solution()
    inverted = solution.invertTree(root)
    assert inverted.val == 4
    assert inverted.left.val == 7 and inverted.right.val == 2
    assert inverted.left.left.val == 9 and inverted.left.right.val == 6
    assert inverted.right.left.val == 3 and inverted.right.right.val == 1
    print("All tests passed.")
