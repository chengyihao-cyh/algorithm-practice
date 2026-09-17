from typing import Optional


class TreeNode:
    def __init__(
        self,
        val: int = 0,
        left: Optional["TreeNode"] = None,
        right: Optional["TreeNode"] = None,
    ) -> None:
        self.val = val
        self.left = left
        self.right = right


class Node:
    def __init__(
        self,
        val: int = 0,
        left: Optional["Node"] = None,
        right: Optional["Node"] = None,
        next: Optional["Node"] = None,
    ) -> None:
        self.val = val
        self.left = left
        self.right = right
        self.next = next


if __name__ == "__main__":
    root = TreeNode(1, TreeNode(2), TreeNode(3))
    assert root.val == 1
    assert root.left is not None and root.left.val == 2
    assert root.right is not None and root.right.val == 3

    nroot = Node(1, Node(2), Node(3))
    assert nroot.val == 1
    assert nroot.left is not None and nroot.left.val == 2
    assert nroot.right is not None and nroot.right.val == 3
    print("All tests passed.")
