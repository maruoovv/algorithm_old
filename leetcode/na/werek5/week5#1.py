# https://leetcode.com/problems/group-anagrams/
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        word_list = []

        for words in strs:
            word_set = list(words)
            word_set.sort()
            if word_set not in word_list:
                word_list.append(word_set)

        answer = [[] for _ in range(len(word_list))]
        
        for i in range(len(strs)):
            input_set = list(strs[i])
            input_set.sort()
            index = word_list.index(input_set)
            answer[index].append(strs[i])

        return answer
        