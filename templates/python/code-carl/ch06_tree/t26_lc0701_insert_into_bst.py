"""LeetCode 701. Insert into a Binary Search Tree
https://leetcode.cn/problems/insert-into-a-binary-search-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        pass


if __name__ == "__main__":

    def inorder(root):
        if root is None:
            return []
        return inorder(root.left) + [root.val] + inorder(root.right)


    root = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(7))
    solution = Solution()
    inserted = solution.insertIntoBST(root, 5)
    assert inorder(inserted) == [1, 2, 3, 4, 5, 7]

    solution = Solution()
    inserted2 = solution.insertIntoBST(None, 5)
    assert inorder(inserted2) == [5]
    print("All tests passed.")
