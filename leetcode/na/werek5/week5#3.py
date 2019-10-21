# https://leetcode.com/problems/merge-intervals/
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals = sorted(intervals, key= lambda x : x[0])
        answer = []
        interval_index, answer_index = 0, 0
        while interval_index < len(intervals):
            if len(answer) == 0:
                answer.append(intervals[interval_index])
            else:
                if answer[answer_index][1] >= intervals[interval_index][0]:
                    answer[answer_index][0] = min(answer[answer_index][0], intervals[interval_index][0])
                    answer[answer_index][1] = max(answer[answer_index][1], intervals[interval_index][1])
                else:
                    answer.append(intervals[interval_index])
                    answer_index += 1
            interval_index += 1
            
        return answer