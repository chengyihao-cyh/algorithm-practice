"""LeetCode 669. Trim a Binary Search Tree
https://leetcode.cn/problems/trim-a-binary-search-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def trimBST(
        self, root: Optional[TreeNode], low: int, high: int
    ) -> Optional[TreeNode]:
        pass


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


    root1 = TreeNode(1, TreeNode(0), TreeNode(2))
    solution = Solution()
    trimmed1 = solution.trimBST(root1, 1, 2)
    assert level_values(trimmed1) == [1, None, 2]

    root2 = TreeNode(3, TreeNode(0, None, TreeNode(2, TreeNode(1))), TreeNode(4))
    solution = Solution()
    trimmed2 = solution.trimBST(root2, 1, 3)
    assert level_values(trimmed2) == [3, 2, None, 1]

    print("All tests passed.")
