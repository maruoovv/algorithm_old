# https://leetcode.com/problems/copy-list-with-random-pointer/
"""
# Definition for a Node.
"""
class Node:
    def __init__(self, val, next, random):
        self.val = val
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        #return copy.deepcopy(head)
        
        if not head:
            return head
        
        copy_list = {}
        
        pos = head
        while pos:
            copy_list[pos] = Node(pos.val, None, None)
            pos = pos.next

        pos = head
        while pos:
            if pos.next:
                copy_list[pos].next = copy_list[pos.next]
            if pos.random:
                copy_list[pos].random = copy_list[pos.random]
            pos = pos.next

        return copy_list[head]