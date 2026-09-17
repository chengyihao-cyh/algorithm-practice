"""LeetCode 112. Path Sum
https://leetcode.cn/problems/path-sum/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root:
            return False
        if not root.left and not root.right:
            return root.val == targetSum
        if self.hasPathSum(root.left, targetSum - root.val):
            return True
        return self.hasPathSum(root.right, targetSum - root.val)


if __name__ == "__main__":
    solution = Solution()
    root1 = TreeNode(
        5,
        TreeNode(4, TreeNode(11, TreeNode(7), TreeNode(2))),
        TreeNode(8, TreeNode(13), TreeNode(4, None, TreeNode(1))),
    )
    assert solution.hasPathSum(root1, 22) is True

    root2 = TreeNode(1, TreeNode(2), TreeNode(3))
    assert solution.hasPathSum(root2, 5) is False

    assert solution.hasPathSum(None, 0) is False
    print("All tests passed.")
