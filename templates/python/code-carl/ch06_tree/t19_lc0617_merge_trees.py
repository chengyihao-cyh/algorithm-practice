"""LeetCode 617. Merge Two Binary Trees
https://leetcode.cn/problems/merge-two-binary-trees/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def mergeTrees(
        self, root1: Optional[TreeNode], root2: Optional[TreeNode]
    ) -> Optional[TreeNode]:
        pass


if __name__ == "__main__":

    root1 = TreeNode(1, TreeNode(3, TreeNode(5)), TreeNode(2))
    root2 = TreeNode(2, TreeNode(1, None, TreeNode(4)), TreeNode(3, None, TreeNode(7)))
    solution = Solution()
    merged = solution.mergeTrees(root1, root2)

    assert merged.val == 3
    assert merged.left.val == 4 and merged.right.val == 5
    assert merged.left.left.val == 5
    assert merged.left.right.val == 4
    assert merged.right.right.val == 7

    root3 = TreeNode(1)
    root4 = TreeNode(1, TreeNode(2))
    solution = Solution()
    merged2 = solution.mergeTrees(root3, root4)
    assert merged2.val == 2
    assert merged2.left is not None and merged2.left.val == 2

    print("All tests passed.")
