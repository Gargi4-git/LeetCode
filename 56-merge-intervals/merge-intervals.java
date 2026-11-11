
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort by starting time
        Arrays.sort(intervals, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        // Step 2: Create result list
        List<int[]> result = new ArrayList<>();

        // Step 3: Add the first interval
        result.add(intervals[0]);

        // Step 4: Process remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int[] current = intervals[i];

            // Get the last merged interval
            int[] last = result.get(result.size() - 1);

            // Check if intervals overlap
            if (current[0] <= last[1]) {

                // Merge intervals
                last[1] = Math.max(last[1], current[1]);

            } else {

                // No overlap: add current interval
                result.add(current);
            }
        }

        // Step 5: Convert List to 2D array
        return result.toArray(new int[result.size()][]);
    }
}
