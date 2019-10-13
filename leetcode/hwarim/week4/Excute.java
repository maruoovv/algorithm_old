package week4;

import java.util.List;

public class Excute {
	static FindFirstAndLastPositionInSortedArray excute1 = new FindFirstAndLastPositionInSortedArray();
	static Permutations excute2 = new Permutations();
	static RotateImage excute3 = new RotateImage();

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int[] answer1;
		
		answer1 = excute1.searchRange(nums, 8);
		for (int i = 0; i < answer1.length; i++)
			System.out.print(answer1[i] + " ");
		System.out.println("\n");
				
		int[] nums2 = { 1, 2, 3 };
		List<List<Integer>> answer2;
		answer2 = excute2.permute(nums2);
		for(int i=0; i<answer2.size();i++) {
			List<Integer> tmp= answer2.get(i);
			for(int j=0;j<tmp.size();j++) System.out.print(tmp.get(j)+" ");
			System.out.println();
		}
				
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		excute3.rotate(matrix);

	}

}
