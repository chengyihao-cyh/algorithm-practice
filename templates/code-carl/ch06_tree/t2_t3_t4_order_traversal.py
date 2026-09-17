"""LeetCode Problems:
- 144. Binary Tree Preorder Traversal
  https://leetcode.cn/problems/binary-tree-preorder-traversal/
- 94. Binary Tree Inorder Traversal
  https://leetcode.cn/problems/binary-tree-inorder-traversal/
- 145. Binary Tree Postorder Traversal
  https://leetcode.cn/problems/binary-tree-postorder-traversal/
"""

from typing import List, Optional

from tree_node import TreeNode


class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        pass

    def preorder(self, root: Optional[TreeNode], list: List[int]) -> None:
        pass

    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        pass

    def inorder(self, root: Optional[TreeNode], list: List[int]) -> None:
        pass

    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        pass

    def postorder(self, root: Optional[TreeNode], list: List[int]) -> None:
        pass

    def preorderTraversalByIter(self, root: Optional[TreeNode]) -> List[int]:
        pass

    def postorderTraversalByIter(self, root: Optional[TreeNode]) -> List[int]:
        pass

    def inorderTraversalByIter(self, root: Optional[TreeNode]) -> List[int]:
        pass

    def inorderTraversalByMonitor(self, root: Optional[TreeNode]) -> List[int]:
        pass

    def preorderTraversalByMonitor(self, root: Optional[TreeNode]) -> List[int]:
        pass

    def postorderTraversalByMonitor(self, root: Optional[TreeNode]) -> List[int]:
        pass


if __name__ == "__main__":
    root = TreeNode(1, None, TreeNode(2, TreeNode(3)))

    solution = Solution()
    assert solution.preorderTraversal(root) == [1, 2, 3]
    solution = Solution()
    assert solution.inorderTraversal(root) == [1, 3, 2]
    solution = Solution()
    assert solution.postorderTraversal(root) == [3, 2, 1]

    solution = Solution()
    assert solution.preorderTraversalByIter(root) == [1, 2, 3]
    solution = Solution()
    assert solution.inorderTraversalByIter(root) == [1, 3, 2]
    solution = Solution()
    assert solution.postorderTraversalByIter(root) == [3, 2, 1]

    solution = Solution()
    assert solution.preorderTraversalByMonitor(root) == [1, 2, 3]
    solution = Solution()
    assert solution.inorderTraversalByMonitor(root) == [1, 3, 2]
    solution = Solution()
    assert solution.postorderTraversalByMonitor(root) == [3, 2, 1]

    print("All tests passed.")
