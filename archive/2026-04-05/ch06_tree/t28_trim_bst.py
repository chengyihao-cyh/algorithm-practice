"""LeetCode 669. Trim a Binary Search Tree
https://leetcode.cn/problems/trim-a-binary-search-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def trimBST(
            self, root: Optional[TreeNode], low: int, high: int
    ) -> Optional[TreeNode]:
        if not root:
            return None
        elif root.val < low:
            return self.trimBST(root.right, low, high)
        elif root.val > high:
            return self.trimBST(root.left, low, high)
        else:
            root.left = self.trimBST(root.left, low, high)
            root.right = self.trimBST(root.right, low, high)
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

    root1 = TreeNode(1, TreeNode(0), TreeNode(2))
    trimmed1 = solution.trimBST(root1, 1, 2)
    assert level_values(trimmed1) == [1, None, 2]

    root2 = TreeNode(3, TreeNode(0, None, TreeNode(2, TreeNode(1))), TreeNode(4))
    trimmed2 = solution.trimBST(root2, 1, 3)
    assert level_values(trimmed2) == [3, 2, None, 1]

    print("All tests passed.")
