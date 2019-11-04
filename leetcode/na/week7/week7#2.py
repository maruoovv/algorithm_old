# https://leetcode.com/problems/validate-binary-search-tree/
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def recursion(self, node: TreeNode, min_val=float('-inf'), max_val=float('inf')) -> bool:
        if not node:
            return True

        if node.val <= min_val or node.val >= max_val:
            return False
        
        if not self.recursion(node.left, min_val, node.val):
            return False
        if not self.recursion(node.right, node.val, max_val):
            return False
        
        return True

        

    def isValidBST(self, root: TreeNode) -> bool:
        return self.recursion(root)
                