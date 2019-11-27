class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> pre = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            pre.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            pre.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int[] takenLecture = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!checkCycle(takenLecture, i, pre)) return false;
        }
        
        return true;
    }
    
    public boolean checkCycle(int[] takenLecture, int course, List<List<Integer>> visit) {
        if (takenLecture[course] == -1)
            return false;

        if (takenLecture[course] == 1)
            return true;


        takenLecture[course] = -1;

        List<Integer> list = visit.get(course);
        for (Integer c : list) {
            if (!checkCycle(takenLecture, c, visit)) return false;
        }


        takenLecture[course] = 1;
        return true;
    }
}
