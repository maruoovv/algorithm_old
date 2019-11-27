# https://leetcode.com/problems/number-of-islands/
class Solution:
    def __init__(self):
        self.row = int
        self.col = int
        self.visited = []
        self.grid = []


    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        
        self.row, self.col = len(grid), len(grid[0])
        self.grid = grid
        self.visited = [[False for _ in range(self.col)] for _ in range(self.row)]
        
        count = 0
        for i in range(self.row):
            for j in range(self.col):
                if not self.visited[i][j] and self.grid[i][j] == '1':
                    self.dfs_recursion(i, j)
                    count += 1
        return count
        
    def dfs_recursion(self, i, j):
        if i < 0 or j < 0 or i >= self.row or j >= self.col:
            return 

        if self.grid[i][j] == '0' or self.visited[i][j] == True:
            return 

        self.visited[i][j] = True

        self.dfs_recursion(i+1, j)
        self.dfs_recursion(i-1, j)
        self.dfs_recursion(i, j+1)
        self.dfs_recursion(i, j-1)