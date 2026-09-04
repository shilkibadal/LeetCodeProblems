import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort by starting value
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Add the first interval
        result.add(intervals[0]);

        // Step 2: Check remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int[] last = result.get(result.size() - 1);
            int[] current = intervals[i];

            // Overlapping
            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            }

            // Not overlapping
            else {
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}