
class Solution {
    int answer;

    public int numSquares(int n) {
        HashMap<Integer,Integer> checked=new HashMap<Integer,Integer>();
        answer=n;
        int start = (int) Math.sqrt(n);
        for(int i=start;i>1;i--){
            answer=Math.min(findleast(n, i,checked,1),answer);
        }
        
        return answer;
    }

    public int findleast(int n, int s,HashMap<Integer,Integer> checked, int count){
       
        if(n<4){
            //1,2,3
            return n;
        }
        
        int curN = n - s*s;
        if(checked.containsKey(curN)){
            return 1+checked.get(curN);
        }
                
        if(count+1>answer) return count;

        int curS = (int) Math.sqrt(curN);
        int m=curN;
        for(int i=curS;i>1;i--){
            m = Math.min(findleast(curN, i,checked,count+1),m);
        }
        checked.put(curN,m);
        return m+1;
        
        
        
    }

}
