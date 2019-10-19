package sim.week5;

public class CanJump {
    public boolean canJump(int[] nums) {
        int len = nums.length;

        boolean[] canJump = new boolean[len];
        canJump[0] = true;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0 && canJump[i]) {
                canJump[i] = true;
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j >= len) return true;
                    canJump[i + j] = true;
                }
            }
        }

        return canJump[len - 1];
    }
}
