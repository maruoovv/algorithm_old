class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)  return false;
        if(matrix[0].length==0) return false;
        
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0; i<matrix.length;i++){
            if(matrix[i][0]==target||target==matrix[i][matrix[0].length-1]) return true;
            if(matrix[i][0]<target&&target<matrix[i][matrix[0].length-1]){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            if(Arrays.binarySearch(matrix[q.poll()],target)>0) return true;
        }
        
        return false;
        
    }
}