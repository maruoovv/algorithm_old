class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int len = nums.length;
        int[] max = new int[len];
        
        for (int j = 0; j < len; j++) {
            max[j] = 1;
        }
        
        int ans = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max[i] = max[i] > max[j] + 1 ? max[i] : max[j] + 1;
                } 
            }
            
            ans = ans > max[i] ? ans : max[i];
        }
        
        return ans;
    }
}
