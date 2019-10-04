# https://leetcode.com/problems/generate-parentheses/
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        answer = []
        def backTrack(s, left, right):
            if right < left:
                return
            
            if left == 0 and right == 0:
                answer.append(s)
                return

            if left > 0:
                backTrack(s + '(', left-1, right)
            if right > 0:
                backTrack(s + ')', left, right-1)

        backTrack('', n, n)
        return answer