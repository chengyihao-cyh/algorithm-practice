"""LeetCode 538. Convert BST to Greater Tree
https://leetcode.cn/problems/convert-bst-to-greater-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        pre_sum: int = 0

        def traversal(root: Optional[TreeNode]) -> Optional[TreeNode]:
            nonlocal pre_sum

            if not root:
                return
            traversal(root.right)
            root.val += pre_sum
            pre_sum = root.val
            traversal(root.left)

        traversal(root)
        return root


if __name__ == "__main__":

    def level_values(root):
        if root is None:
            return []
        queue = [root]
        res = []
        while queue:
            node = queue.pop(0)
            if node is None:
                res.append(None)
                continue
            res.append(node.val)
            queue.append(node.left)
            queue.append(node.right)
        while res and res[-1] is None:
            res.pop()
        return res


    solution = Solution()
    root = TreeNode(
        4,
        TreeNode(1, TreeNode(0), TreeNode(2, None, TreeNode(3))),
        TreeNode(6, TreeNode(5), TreeNode(7, None, TreeNode(8))),
    )
    converted = solution.convertBST(root)
    expected = [30, 36, 21, 36, 35, 26, 15, None, None, None, 33, None, None, None, 8]
    assert level_values(converted) == expected

    root2 = TreeNode(0, None, TreeNode(1))
    converted2 = solution.convertBST(root2)
    assert level_values(converted2) == [1, None, 1]

    assert solution.convertBST(None) is None
    print("All tests passed.")
