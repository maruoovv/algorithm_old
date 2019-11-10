# https://leetcode.com/problems/binary-tree-level-order-traversal/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        stack = [root]
        print_list = []
        while len(stack) > 0:
            level_nodes = []
            val_list = []
            while len(stack) > 0:
                level_nodes.append(stack.pop(0))
            
            for node in level_nodes:
                if node.left:
                    stack.append(node.left)
                if node.right:
                    stack.append(node.right)
                val_list.append(node.val)
            print_list.append(val_list)
        return print_list

