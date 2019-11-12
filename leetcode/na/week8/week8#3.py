# https://leetcode.com/problems/word-break/
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
       
        breaking_index = [0]

        for index in range(len(s)):
            for i in range(len(breaking_index)-1, -1, -1):
                break_point = breaking_index[i]
                if s[break_point:index+1] in wordDict:
                    breaking_index.append(index+1)
                    break

        return breaking_index[-1] == len(s)

"""
dp = [False] * (len(s) + 1) # dp[i] means s[:i+1] can be segmented into words in the wordDicts 
        dp[0] = True
        for i in range(len(s)):
            for j in range(i, len(s)):
                if dp[i] and s[i: j+1] in wordDict:
                    dp[j+1] = True
                    
        return dp[-1]
"""