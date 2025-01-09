class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
   public static int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        int[][] meetings = new int[n][2];

        // Step 1: Create an array of meetings with (start, end) pairs
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        // Step 2: Sort the meetings based on end time (second element of each pair)
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[1]));

        // Step 3: Select the meetings
        int count = 1; // We can always select the first meeting
        int last_end = meetings[0][1]; // End time of the first meeting

        // Step 4: Iterate through remaining meetings
        for (int i = 1; i < n; i++) {
            // Ensure the start time is strictly greater than the last end time
            if (meetings[i][0] > last_end) {
                count++;
                last_end = meetings[i][1]; // Update the last_end to the current meeting's end time
            }
        }

        return count;
    }
}
