// memoization
class Solution {
    public int climbStairs(int n) {
        // distinct case means, we reach or exceed n
        // to go towards n, we can do plus 1 or plus 2
        int[] memo = new int[n];
        Arrays.fill(memo,-1);
        return func(0,n,memo);
    }
    public int func(int curr, int n, int[] memo){
        if(curr == n) return 1;
        if(curr > n) return 0;
        if(memo[curr]==-1) memo[curr]= func(curr+1,n,memo) + func(curr+2,n,memo);
        return memo[curr];
    }
    
}

// tabulation
class Solution {
    public int climbStairs(int n) {
        // distinct case means, we reach or exceed n
        // to go towards n, we can do plus 1 or plus 2
        int[] memo = new int[n+1];
        memo[0]=1;
        memo[1] = 1;
        for(int i =2;i<=n;i++) memo[i]= memo[i-2]+memo[i-1];                
        return memo[n];    
    }
}
