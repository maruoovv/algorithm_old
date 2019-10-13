package week4;

import java.util.*;
//leetcode #46
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		if (nums.length == 0) {
			List<List<Integer>> answer = new ArrayList<List<Integer>>();
			answer.add(new ArrayList<Integer>());
			return answer;
		}
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> permutation = new ArrayList<Integer>();
		boolean[] checked = new boolean[nums.length];
		return makePermutation(nums, answer, 0, permutation, checked);
	}

	private List<List<Integer>> makePermutation(int[] nums, List<List<Integer>> answer, int depth,
			List<Integer> permutation, boolean[] checked) {
		if (nums.length == depth) {
			answer.add(permutation);
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (!checked[i]) {
					List<Integer> tmp = new ArrayList<Integer>();
					boolean[] tmpChecked = checked.clone();
					tmp.addAll(permutation);
					tmp.add(nums[i]);
					tmpChecked[i] = true;
					answer = makePermutation(nums, answer, depth + 1, tmp, tmpChecked);
				}
			}
		}
		return answer;
	}
}
