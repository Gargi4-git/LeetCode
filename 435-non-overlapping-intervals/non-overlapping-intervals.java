
import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // Sort intervals by ending time
        Arrays.sort(intervals, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        int removed = 0;

        // End time of the last selected interval
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // If current interval overlaps
            if (intervals[i][0] < lastEnd) {
                removed++;
            }

            // Otherwise, keep the current interval
            else {
                lastEnd = intervals[i][1];
            }
        }

        return removed;
    }
}
