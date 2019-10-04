class SearchInRotatedSortedArray{
    public int search(int[] nums, int target) {
        int length=nums.length,start,targetIndex;
        if(length<1) return -1;
        int[] nums2= nums.clone();
        Arrays.sort(nums2);
        targetIndex=Arrays.binarySearch(nums2,target);
        if(targetIndex<0) return -1;
        start=Arrays.binarySearch(nums2,nums[0]);
               
        if(targetIndex<start) return length-start+targetIndex;
        else return targetIndex-start;
       
    }
}