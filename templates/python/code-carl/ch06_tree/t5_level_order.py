"""LeetCode Problems:
- 102. Binary Tree Level Order Traversal
  https://leetcode.cn/problems/binary-tree-level-order-traversal/
- 107. Binary Tree Level Order Traversal II
  https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
- 199. Binary Tree Right Side View
  https://leetcode.cn/problems/binary-tree-right-side-view/
- 637. Average of Levels in Binary Tree
  https://leetcode.cn/problems/average-of-levels-in-binary-tree/
- 429. N-ary Tree Level Order Traversal
  https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
- 515. Find Largest Value in Each Tree Row
  https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
- 116. Populating Next Right Pointers in Each Node
  https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
- 104. Maximum Depth of Binary Tree
  https://leetcode.cn/problems/maximum-depth-of-binary-tree/
- 111. Minimum Depth of Binary Tree
  https://leetcode.cn/problems/minimum-depth-of-binary-tree/
"""

from typing import List, Optional

from tree_node import Node, TreeNode


class Solution:
    def levelOrderByIter(self, root: Optional[TreeNode]) -> List[List[int]]:
        pass

    def levelOrderByRes(self, root: Optional[TreeNode]) -> List[List[int]]:
        pass

    def orderByRes(self, root: Optional[TreeNode], depth: int, res: List[int]) -> None:
        pass

    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        pass

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        pass

    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        pass

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        pass

    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        pass

    def connect(self, root: Optional[Node]) -> Optional[Node]:
        pass

    def maxDepth(self, root: Optional[TreeNode]) -> int:
        pass

    def minDepth(self, root: Optional[TreeNode]) -> int:
        pass


if __name__ == "__main__":
    root = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))

    solution = Solution()
    assert solution.levelOrderByIter(root) == [[3], [9, 20], [15, 7]]
    solution = Solution()
    assert solution.levelOrderByRes(root) == [[3], [9, 20], [15, 7]]
    solution = Solution()
    assert solution.levelOrderBottom(root) == [[15, 7], [9, 20], [3]]
    solution = Solution()
    assert solution.rightSideView(root) == [3, 20, 7]
    solution = Solution()
    assert solution.averageOfLevels(root) == [3.0, 14.5, 11.0]
    solution = Solution()
    assert solution.largestValues(root) == [3, 20, 15]
    solution = Solution()
    assert solution.maxDepth(root) == 3
    solution = Solution()
    assert solution.minDepth(root) == 2

    nroot = Node(1, Node(2, Node(4), Node(5)), Node(3, Node(6), Node(7)))
    solution = Solution()
    connected = solution.connect(nroot)
    assert connected.left.next is connected.right
    assert connected.left.left.next is connected.left.right
    assert connected.left.right.next is connected.right.left

    print("All tests passed.")
