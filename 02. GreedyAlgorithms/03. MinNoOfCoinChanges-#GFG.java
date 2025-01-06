// Java program to find minimum of coins
// to make a given change sum

import java.util.Arrays;

class GfG {

    static int minCoinsRecur(int i, int sum, int[] coins) {
        
        // base case
        if (sum == 0) return 0;
        if (sum < 0 || i == coins.length) return Integer.MAX_VALUE;
        
        int take = Integer.MAX_VALUE;
        
        // take a coin only if its value
        // is greater than 0.
        if (coins[i] > 0) {
            take = minCoinsRecur(i, sum - coins[i], coins);
            if (take != Integer.MAX_VALUE) take++;
        }
        
        int noTake = minCoinsRecur(i + 1, sum, coins);
        
        return Math.min(take, noTake);
    }

    static int minCoins(int[] coins, int sum) {
        int ans = minCoinsRecur(0, sum, coins);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    public static void main(String[] args) {
        int[] coins = {9, 6, 5, 1};
        int sum = 19;
        System.out.println(minCoins(coins, sum));
    }
}
