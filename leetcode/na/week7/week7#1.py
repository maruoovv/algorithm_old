# https://leetcode.com/problems/unique-binary-search-trees/
# reference: https://www.geeksforgeeks.org/python-program-for-program-for-nth-catalan-number/
class Solution:
    def catalan(self, n):
        # base case
        if n <= 1:
            return 1

        # catalan(n) = sum of catalan(i)*catalan(n-i-1)
        res = 0
        for i in range(n):
            res += self.catalan(i) * self.catalan(n-i-1)
        return res

    def numTrees(self, n: int) -> int:
        return self.catalan(n)