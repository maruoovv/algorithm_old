package week5;

public class Excute5 {
	static GroupAnagrams excute1=new GroupAnagrams(); 
	static JumpGame excute2=new JumpGame();
	static MergeIntervals excute3=new MergeIntervals();
	public static void main(String[] args) {
		String[] strs= {"eat", "tea", "tan", "ate", "nat", "bat"};
		excute1.groupAnagrams(strs);
		
		int[] nums={2,5,0,0};
		excute2.canJump(nums);
		
		int[][] intervals= {{1,3},{2,6},{8,10},{15,18}};
		excute3.merge(intervals);
	}

}
