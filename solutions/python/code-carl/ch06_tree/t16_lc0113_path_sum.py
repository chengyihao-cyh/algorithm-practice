"""LeetCode 113. Path Sum II
https://leetcode.cn/problems/path-sum-ii/
"""

from typing import List, Optional

from tree_node import TreeNode


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return []

        path: List[int] = []
        ans: List[List[int]] = []

        def traversal(root: Optional[TreeNode], targetSum: int) -> None:
            if not root.left and not root.right:
                if targetSum == root.val:
                    path.append(root.val)
                    ans.append(path.copy())
                    path.pop()
                return

            path.append(root.val)
            if root.left:
                traversal(root.left, targetSum - root.val)
            if root.right:
                traversal(root.right, targetSum - root.val)
            path.pop()

        traversal(root, targetSum)
        return ans


if __name__ == "__main__":
    solution = Solution()
    root1 = TreeNode(
        5,
        TreeNode(4, TreeNode(11, TreeNode(7), TreeNode(2))),
        TreeNode(8, TreeNode(13), TreeNode(4, TreeNode(5), TreeNode(1))),
    )
    result1 = sorted(solution.pathSum(root1, 22))
    expected = sorted([[5, 4, 11, 2], [5, 8, 4, 5]])
    assert result1 == expected

    root2 = TreeNode(1, TreeNode(2), TreeNode(3))
    assert solution.pathSum(root2, 5) == []

    root3 = TreeNode(1, TreeNode(2))
    assert solution.pathSum(root3, 0) == []
    print("All tests passed.")
