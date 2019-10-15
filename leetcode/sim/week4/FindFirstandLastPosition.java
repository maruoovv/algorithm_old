package sim.week4;

import java.util.Arrays;

public class FindFirstandLastPosition {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        searchRange(nums, 8);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        answer[0] = nums.length + 1;
        answer[1] = -1;

        int[] ans = findTarget(nums, target, 0, answer);

        if (ans[0] == nums.length + 1) {
            answer[0] = -1;
            answer[1] = -1;
        } else {
            answer[0] = ans[0];
            answer[1] = ans[1];
        }

        return answer;
    }

    public static int[] findTarget(int[] nums, int target, int start, int[] answer) {
        int length = nums.length;

        if (nums.length == 0) {
            return answer;
        }

        int index = Arrays.binarySearch(nums, target);

        if (index < 0) {
            return answer;
        }

        if (answer[0] > (index+start) && index >= 0) {
            answer[0] = index + start;
        }

        if (answer[1] < (index+start)  && index >= 0) {
            answer[1] = index + start;
        }

        if (length == 1) {
            return answer;
        }

        findTarget(Arrays.copyOfRange(nums, 0, (length / 2)), target, start, answer);
        findTarget(Arrays.copyOfRange(nums, length / 2 , length), target,start + (length / 2) , answer);

        return answer;
    }
}
