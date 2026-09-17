"""LeetCode 111. Minimum Depth of Binary Tree
https://leetcode.cn/problems/minimum-depth-of-binary-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        elif not root.right:
            return self.minDepth(root.left) + 1
        elif not root.left:
            return self.minDepth(root.right) + 1
        else:
            return min(self.minDepth(root.left), self.minDepth(root.right)) + 1


if __name__ == "__main__":
    solution = Solution()
    root1 = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
    assert solution.minDepth(root1) == 2

    root2 = TreeNode(
        2, None, TreeNode(3, None, TreeNode(4, None, TreeNode(5, None, TreeNode(6))))
    )
    assert solution.minDepth(root2) == 5

    print("All tests passed.")
