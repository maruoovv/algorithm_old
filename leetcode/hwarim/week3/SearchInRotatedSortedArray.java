class SearchInRotatedSortedArray{
    public int search(int[] nums, int target) {
        int start,targetIndex;
        
        if(nums.length<1) return -1;

        start=searchStart(nums,0,nums.length);
        
        targetIndex=Arrays.binarySearch(nums,0,start+1,target);
        
        if(0<=targetIndex) return targetIndex;
        
        targetIndex=Arrays.binarySearch(nums,start+1,nums.length,target);

        if(targetIndex<0) return -1;
                       
        return targetIndex;
       
    }
    
    public int searchStart(int[] nums,int left,int right){
        int middle,start=-1;
        middle=left+(right-left)/2;
        if(middle<nums.length-1&&nums[middle]>nums[middle+1]) return middle;  
   
        if(left<middle){
            start=searchStart(nums,left,middle); 
            if(start!=-1) return start;
        }
        
        if(middle+1<right){
            start=searchStart(nums,middle+1,right); 
            if(start!=-1) return start;
        }
        
        return -1 ;
    }
}