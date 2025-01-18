class Solution {
    //    public int[][] insert(int[][] intervals, int[] newInterval) {
    //     // Edge case when intervals array is empty
    //     if (intervals.length == 0) {
    //         return new int[][]{newInterval};
    //     }

    //     // Sort intervals based on the starting times
    //     Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    //     int m1 = -1;
    //     int m2 = -1;

    //     // Find the intervals that overlap with the new interval
    //     for (int i = 0; i < intervals.length; i++) {
    //         if (m1 == -1 && intervals[i][1] >= newInterval[0]) {
    //             m1 = i;
    //         }
    //         if (intervals[i][0] <= newInterval[1]) {
    //             m2 = i;
    //         } else {
    //             break;
    //         }
    //     }

    //     // If no overlap found, m2 should be equal to m1
    //     if (m2 == -1) {
    //         m2 = m1;
    //     }

    //     // Calculate the new size of the intervals after merging
    //     int sz = intervals.length - (m2 - m1);
    //     int[][] ans = new int[sz][2];
    //     boolean flag = false;
    //     int j = 0;

    //     // Merge intervals and construct the result
    //     for (int i = 0; i < intervals.length; i++) {
    //         if (flag && i != m2) {
    //             continue;
    //         }

    //         if (i == m2) {
    //             ans[j][1] = Math.max(intervals[i][1], newInterval[1]);
    //             j++;
    //             continue;
    //         }

    //         if (i == m1) {
    //             ans[j][0] = Math.min(intervals[i][0], newInterval[0]);
    //             flag = true;
    //             j++;
    //             continue;
    //         }

    //         ans[j][0] = intervals[i][0];
    //         ans[j][1] = intervals[i][1];
    //         j++;
    //     }

    //     // In case the new interval is after all existing intervals
    //     if (m1 == -1 && m2 == -1) {
    //         ans = new int[intervals.length + 1][2];
    //         for (int i = 0; i < intervals.length; i++) {
    //             ans[i] = intervals[i];
    //         }
    //         ans[intervals.length] = newInterval;
    //     }
    //     return ans;
    // }
        public int[][] insert(int[][] intervals, int[] newInterval) {
        // List to hold the merged intervals
        List<int[]> result = new ArrayList<>();
        
        int i = 0;
        int n = intervals.length;
        
        // Add all intervals that end before the new interval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        // Add the merged interval
        result.add(newInterval);
        
        // Add the remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        
        // Convert the list back to an array
        return result.toArray(new int[result.size()][]);
    }

}
