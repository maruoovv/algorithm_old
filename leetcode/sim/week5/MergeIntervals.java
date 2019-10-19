package sim.week5;

import java.util.*;

public class MergeIntervals {
    class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;

        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        list.sort(Comparator.comparing(a -> a.start));

        List<Interval> res = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (res.isEmpty() || res.get(res.size() -1).end < list.get(i).start) {
                res.add(list.get(i));
            } else {
                Interval interval = res.get(res.size() - 1);
                interval.end = interval.end > list.get(i).end ? interval.end : list.get(i).end;
            }
        }

        int[][] result = new int[res.size()][2];

        for (int i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i).start;
            result[i][1] = res.get(i).end;
        }

        return result;
    }
}
