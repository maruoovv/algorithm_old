# https://leetcode.com/problems/implement-trie-prefix-tree/
# from collections import defaultdict
class TrieNode:
    def __init__(self):
        self.node = dict()
        # self.nodes = defaultdict(TrieNode)  # Easy to insert new node.
        self.isEnd = False


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for char in word:
            # curr = curr.nodes[char]
            if char not in curr.node:
                curr.node[char] = TrieNode()
            curr = curr.node[char]
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for char in word:
            if char not in curr.node:
                return False
            curr = curr.node[char]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for char in prefix:
            if char not in curr.node:
                return False
            curr = curr.node[char]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)