class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output=new int[nums.length];
        int left=1,right=1,length=nums.length-1;
        boolean mid=false;
        if(length%2==0) mid=true;
        for(int i=0; i<=length; i++){
            if(i==length/2&&mid){
                output[i]=left*right;   
            }
            else if(i<=length/2){
                output[i]=left;
                output[length-i]=right;
            }
            else{
                output[i]*=left;
                output[length-i]*=right;    
            }
            left*=nums[i];
            right*=nums[length-i];
        }
        return output;
    }
}