"""LeetCode 106. Construct Binary Tree from Inorder and Postorder Traversal
https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
"""

from typing import List, Optional

from tree_node import TreeNode


class Solution:
    def buildTree(
        self, inorder: List[int], postorder: List[int]
    ) -> Optional[TreeNode]:
        pass


if __name__ == "__main__":
    solution = Solution()
    root1 = solution.buildTree([9, 3, 15, 20, 7], [9, 15, 7, 20, 3])
    assert root1.val == 3
    assert root1.left.val == 9
    assert root1.right.val == 20
    assert root1.right.left.val == 15
    assert root1.right.right.val == 7

    solution = Solution()
    root2 = solution.buildTree([-1], [-1])
    assert root2 is not None and root2.val == -1
    print("All tests passed.")
