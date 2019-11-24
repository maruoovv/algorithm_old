class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++ ){
            int temp = nums[i];
            int tempMax = Math.max(temp, Math.max(temp*max, temp*min));
            int tempMin = Math.min(temp, Math.min(temp*max, temp*min));
            res = Math.max(res, tempMax);
            max = tempMax;
            min = tempMin;
        }
        
        return res;
    }
}
