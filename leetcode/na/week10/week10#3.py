# https://leetcode.com/problems/course-schedule/
# https://leetcode.com/problems/course-schedule/discuss/58586/Python-20-lines-DFS-solution-sharing-with-explanation
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # 수업별 선수과목 정보 (key:수업, value:선수과목 List)
        class_info = [[] for _ in range(numCourses)]    
        # 듣고 있는 수업:-1, 완료한 수업:1
        visited = [0 for _ in range(numCourses)]
        
        for classes in prerequisites:
            after, before = classes
            class_info[after].append(before)

        for i in range(numCourses):
            checker = self.checkCurriculum(class_info, visited, i)
            if checker == False:
                return False
        return True

    def checkCurriculum(self, class_info, visited, current):
        # 수강과목이 선수과목 전에 들어야하는 과목임 (cycle)
        if visited[current] == -1:
            return False
        
        # 이미 수강완료한 과목
        if visited[current] == 1:
            return True

        # 수강중
        visited[current] = -1

        for i in class_info[current]:
            checker = self.checkCurriculum(class_info, visited, i)
            if checker == False:
                return False
        # 수강완료
        visited[current] = 1
        return True