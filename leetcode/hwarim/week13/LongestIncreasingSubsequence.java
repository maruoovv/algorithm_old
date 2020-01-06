class Solution {//크기만구함
    public int lengthOfLIS(int[] nums) {
        if(nums.length<2) return nums.length;
        
        ArrayList<Integer> LIS= new ArrayList<Integer>();
        for(int num:nums){
            if(LIS.size()==0||LIS.get(LIS.size()-1)<num){
                LIS.add(num);
            }else{
                int lowerBound=getLowerBound(LIS,num,0,LIS.size()-1);
                LIS.set(lowerBound,num);
            }
        }
        return LIS.size();
    }
    public int getLowerBound(ArrayList<Integer> LIS, int target, int left, int right){
        if(left<right){
            int mid=(left+right)/2;
            int num=LIS.get(mid).intValue();
            if(num==target)return mid;
            if(target<num){
                return getLowerBound(LIS,target,left,mid);
            }else{
                return getLowerBound(LIS,target,mid+1,right);
            }    
        }
        return left;
    }
}