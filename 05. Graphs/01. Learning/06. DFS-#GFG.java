class Solution {
     // i=0
        // ith index wali list se start krege
            // us list ke ek ek (unvisited) element pe jaana hai
                // us element ko add krke, visit mark krke, uske index pr jayege
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] flags = new boolean[adj.size()];
        func(0,ans,flags,adj);
        return ans;
    }
    public void func(int i, ArrayList<Integer> ans, boolean[] flags, ArrayList<ArrayList<Integer>> adj){
        if(flags[i]==true) return;
        flags[i] = true;
        ans.add(i);
        for(int n : adj.get(i)) func(n,ans,flags,adj);
        return;
    }
}
