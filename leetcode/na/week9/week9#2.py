# https://leetcode.com/problems/lru-cache/
class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:
    
    def __init__(self, capacity: int):
        self.cache = dict()
        self.capacity = capacity

        # 캐시 페이지 링크드리스트
        self.head = Node(0,0)
        self.tail = Node(0,0)
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        if self.cache.get(key):
            pop_node = self.cache[key]
            # delete node
            pop_node.prev.next = pop_node.next
            pop_node.next.prev = pop_node.prev
            # insert node to tail
            pop_node.prev = self.tail.prev
            self.tail.prev.next = pop_node
            pop_node.next = self.tail
            self.tail.prev = pop_node

            return pop_node.value
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        # hit (move node to tail)
        if self.cache.get(key):
            delete_node = self.cache[key]
            delete_node.prev.next = delete_node.next
            delete_node.next.prev = delete_node.prev

        # insert node to tail        
        insert_node = Node(key, value)
        insert_node.prev = self.tail.prev
        self.tail.prev.next = insert_node
        insert_node.next = self.tail
        self.tail.prev = insert_node

        # dictionary update
        self.cache[key] = insert_node

        # capacity check
        if len(self.cache) > self.capacity:
            delete_node = self.head.next
            
            self.head.next = delete_node.next
            self.head.next.prev = self.head

            del self.cache[delete_node.key]

        