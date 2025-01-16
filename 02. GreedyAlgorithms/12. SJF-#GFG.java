
class Solution {
    static int solve(int[] bt) {
        // Sort the burst times in ascending order (Shortest Job First policy)
        Arrays.sort(bt);

        int totalWaitingTime = 0;
        int currentWaitingTime = 0;

        // Calculate total waiting time
        for (int i = 1; i < bt.length; i++) {
            currentWaitingTime += bt[i - 1];
            totalWaitingTime += currentWaitingTime;
        }

        // Calculate average waiting time
        int averageWaitingTime = totalWaitingTime / bt.length;

        return averageWaitingTime; // Return the floor of the average waiting time
    }
}
     
