import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int cutRod(int[] price) {
        int n = price.length;

        // Max-Heap to keep track of the maximum value pieces
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // DP array to store the maximum profit at each length
        int[] dp = new int[n + 1];

        // Initially, a rod of length 0 has 0 profit
        dp[0] = 0;

        // Loop through each possible length from 1 to n
        for (int i = 1; i <= n; i++) {
            maxHeap.clear();  // Clear the heap for each length iteration
            
            // Try all cuts (1 to i) and calculate the maximum profit using heap
            for (int j = 1; j <= i; j++) {
                int currentProfit = price[j - 1] + dp[i - j];
                maxHeap.add(currentProfit);
            }

            // The best profit for a rod of length i is the maximum value in the heap
            dp[i] = maxHeap.peek();
        }

        // The answer will be the maximum profit for the full rod of length n
        return dp[n];
    }
}
