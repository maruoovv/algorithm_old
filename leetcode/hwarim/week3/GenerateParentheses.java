class GenerateParentheses{
    public List<String> generateParenthesis(int n) {
        List<String> answer=new ArrayList<String>();
        answer=makeSet(new String(),n,0,0,answer);
        return answer;
    }
    public List<String> makeSet(String str, int target, int depth, int left, List<String> answer){
        
        if(str.length()==target*2){
            answer.add(str);
            return answer;
        }
        
        if(left<target&&depth<target){
            makeSet(str+"(",target,depth+1,left+1,answer);
        }
        
        if(0<left){
            makeSet(str+")",target,depth,left-1,answer);
        }
        
        return answer;
    }
}