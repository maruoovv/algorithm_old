package week5;

//import java.util.*;
public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums.length < 2)
			return true;
		return dfs(nums, nums[0], 0, new boolean[nums.length]);

	}

	private boolean dfs(int[] nums, int numNow, int indexNow, boolean[] check) {
		check[indexNow] = true;
		if (nums.length - 1 - numNow <= indexNow) {
			return true;
		} else {
			for (int i = indexNow + numNow; indexNow < i; i--) {
				if (!check[i] && nums[i] != 0) {
					if (dfs(nums, nums[i], i, check)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
