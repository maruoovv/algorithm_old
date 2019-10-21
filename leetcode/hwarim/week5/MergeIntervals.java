package week5;

import java.util.*;

public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		if(intervals.length<2)
            return intervals;     
        ArrayList<int[]> tmpSets = new ArrayList<int[]>();
		
        sortSets(intervals);
        int preLeft = intervals[0][0];
        int preRight = intervals[0][1];
        
        int[] e;
        int left, right;
        for (int i = 1; i < intervals.length; i++) {
			left = intervals[i][0];
            right = intervals[i][1];
			if (preRight < left) {
				e = new int[2];
				e[0] = preLeft;
				e[1] = preRight;
				tmpSets.add(e);
				preRight = right;
				preLeft = left;
				continue;
			} else if (preLeft <= left) {
				if (preRight < right) {
					preRight = right;
				}
			}
		}
		e = new int[2];
		e[0] = preLeft;
		e[1] = preRight;
		tmpSets.add(e);
        int[][] answer = new int[tmpSets.size()][2];
		for(int i=0;i<tmpSets.size();i++) {
			answer[i]=tmpSets.get(i);
		}
		return answer;
	}

	private void sortSets(int[][] arrs) {
		Arrays.sort(arrs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] < o2[0])
					return -1;
				else if (o1[0] == o2[0] && o1[1] < o2[1])
					return -1;
				else if (o1[0] == o2[0] && o1[1] == o2[1])
					return 0;
				else
					return 1;
			}
		});
	}
}
