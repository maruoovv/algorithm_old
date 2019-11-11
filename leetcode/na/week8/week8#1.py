# https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        head = TreeNode(0)
        head.right = root

        if not root:
            return root
        
        while root.right or root.left:
            if root.left:
                checker = root.left

                while checker.right:
                    checker = checker.right

                right_child = root.right

                root.right = root.left
                root.left = None
                checker.right = right_child

            root = root.right
        return head.right