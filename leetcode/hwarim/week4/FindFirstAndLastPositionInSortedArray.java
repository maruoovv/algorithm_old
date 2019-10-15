package week4;

import java.util.Arrays;
//leetcode #34
public class FindFirstAndLastPositionInSortedArray {

	public int[] searchRange(int[] nums, int target) {
		if (Arrays.binarySearch(nums, target) < 0) {
			int[] answer = { -1, -1 };
			return answer;
		}

		return searchAll(nums, target, 0, nums.length - 1, new int[2], 0);

	}

	private int[] searchAll(int[] nums, int target, int left, int right, int[] answer, int flag) {
		if (left > right)
			return answer;

		int middle = left + (right - left) / 2;

		if (target == nums[middle]) {
			if (flag == 0 || middle < answer[0])
				answer[0] = middle;
			if (flag == 0 || answer[1] < middle)
				answer[1] = middle;
			flag = 1;// 0이면 처음 상태

			if (middle != 0 && nums[middle - 1] == target) {
				answer = searchAll(nums, target, left, middle - 1, answer, flag);
			}
			if (middle != nums.length - 1 && nums[middle + 1] == target) {
				answer = searchAll(nums, target, middle + 1, right, answer, flag);
			}
		} else if (target < nums[middle]) {
			answer = searchAll(nums, target, left, middle - 1, answer, flag);
		} else {
			answer = searchAll(nums, target, middle + 1, right, answer, flag);
		}

		return answer;
	}
}
