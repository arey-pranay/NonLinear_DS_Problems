// class Solution {
//     public boolean canCross(int[] stones) {
//         // first jump is 1 unit
//         // frog starts from 0, frog needs to land on n
//         // frog can jump only on stones
//         // (k+1)th jump can k-1, k, or k+1 units
        
//         HashSet<Integer> hs = new HashSet<>();
//         for(int i: stones) hs.add(i);
//         if(stones.length==2 && stones[1]!=1) return false;
//         int[] memo = new int[stones[stones.length-1] + 1];
//         Arrays.fill(memo,-1);
//         return func(hs, 0, stones[stones.length-1],1,memo)!=0;
//     }
//     public int func(HashSet<Integer> hs, int curr, int dest, int k, int[] memo){
//         if(!hs.contains(curr) || k<=0) return 0;
//         if(curr == dest) return 1;
//         if(memo[curr] != -1) return memo[curr];
//       int temp = func(hs, curr+k-1, dest, k-1,memo) + func(hs, curr+k, dest, k,memo) + func(hs,curr+k+1, dest, k+1,memo);  
//       if(temp > 0) memo[curr]=1; else memo[curr]=0;
//       return memo[curr];
//     }
   
// }

class Solution {
    public boolean canCross(int[] stones) {
        Set<Integer> setstones = new HashSet<>();
        for(int stone : stones) setstones.add(stone);
        Map<String, Boolean> memo = new HashMap<>();
        return func(stones, 0, 0, memo, setstones);
    }
    private boolean func(int[] stones, int currentstone, int lastjump, Map<String, Boolean> memo, Set<Integer> setstones){
        if(currentstone == stones[stones.length - 1]) return true;
        String string = currentstone + "," + lastjump; // "1,1"
        if(memo.containsKey(string)) return memo.get(string);
        for(int i = -1; i <= 1; i++){
            int nextjump = lastjump + i; // 1+1
            if(nextjump <= 0) continue;
            int nextstone = currentstone + nextjump; //1
            if(setstones.contains(nextstone)) //
                if(func(stones, nextstone, nextjump, memo, setstones)){ //stones, 1, 1, memo, set
                    memo.put(string, true); // "2,1" -> true
                    return true;
                }
        }
        memo.put(string, false);
        return false;
    }
}
