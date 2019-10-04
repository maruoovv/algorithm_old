class NextPermutation{
    public void nextPermutation(int[] nums) {
        int size=nums.length,min=size-1;
        boolean flag=true;
        for(int i=size-1;0<i;i--){
           
            if(nums[i-1]<nums[i]){
                int num=nums[i-1];
                Arrays.sort(nums,i-1,size);
                min=Arrays.binarySearch(nums,i-1,size,num);
                while(nums[min]==num) min++;
                //swap
                int tmp=nums[i-1];
                nums[i-1]=nums[min];
                nums[min]=tmp;
                Arrays.sort(nums,i,size);
                flag=false;
                break;
            }
            
            if(nums[i]<nums[min]) min=i;
        }
        if(flag) Arrays.sort(nums);
    }
}
