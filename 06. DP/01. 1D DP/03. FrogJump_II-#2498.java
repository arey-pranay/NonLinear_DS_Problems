class Solution {
    public int maxJump(int[] stones) {
        int result = stones[1] - stones[0];
        for (int i = 2; i < stones.length; i += 2) result = Math.max(result, stones[i] - stones[i - 2]);
        for (int i = 3; i < stones.length; i += 2) result = Math.max(result, stones[i] - stones[i - 2]);
        return result;
    }
}
