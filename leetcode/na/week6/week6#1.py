# https://leetcode.com/problems/minimum-path-sum/
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m = len(grid)   # 열
        if m == 0:
            return 0
        n = len(grid[0]) # 행

        matrix = [[float('inf')] * (n+1) for _ in range(m+1)]
        """
        [inf, 0, inf, inf]
        [inf, inf, inf, inf]
        [inf, inf, inf, inf]
        [inf, inf, inf, inf]
        """
        matrix[0][1] = 0
        for i in range(1, m+1):
            for j in range(1, n+1):
                matrix[i][j] = min(matrix[i-1][j], matrix[i][j-1]) + grid[i-1][j-1]
         
        return matrix[-1][-1]

def print_matrx(matrix):
    for i in range(len(matrix)):
        print(matrix[i])
    print('\n')
        
input = [
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
temp = Solution()
print(temp.minPathSum(input))