"""LeetCode 450. Delete Node in a BST
https://leetcode.cn/problems/delete-node-in-a-bst/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root:
            return None

        if root.val > key:
            root.left = self.deleteNode(root.left, key)
        elif root.val < key:
            root.right = self.deleteNode(root.right, key)
        else:
            if not root.left:
                return root.right
            elif not root.right:
                return root.left
            else:
                curr = root.right
                while curr.left:
                    curr = curr.left
                curr.left = root.left
                return root.right

        return root


if __name__ == "__main__":

    def inorder(root):
        if root is None:
            return []
        return inorder(root.left) + [root.val] + inorder(root.right)


    solution = Solution()

    root1 = TreeNode(
        5, TreeNode(3, TreeNode(2), TreeNode(4)), TreeNode(6, None, TreeNode(7))
    )
    deleted = solution.deleteNode(root1, 3)
    assert inorder(deleted) == [2, 4, 5, 6, 7]

    root2 = TreeNode(
        5, TreeNode(3, TreeNode(2), TreeNode(4)), TreeNode(6, None, TreeNode(7))
    )
    unchanged = solution.deleteNode(root2, 0)
    assert inorder(unchanged) == [2, 3, 4, 5, 6, 7]

    assert solution.deleteNode(None, 0) is None

    print("All tests passed.")
