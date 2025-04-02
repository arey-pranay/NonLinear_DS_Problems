class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashSet<Integer> hs = new HashSet<>();
        int ans = 0;
        int visiting = 0;
        
        while (hs.size() != isConnected.length) {
            // Find next unvisited node
            while (visiting < isConnected.length && hs.contains(visiting)) {
                visiting++;
            }
            
            // If we've checked all nodes
            if (visiting >= isConnected.length) {
                break;
            }
            
            ans++; // Found a new province
            dfs(hs, isConnected, visiting);
        }
        return ans;
    }
    
    public void dfs(HashSet<Integer> hs, int[][] isConnected, int curr) {
        if (hs.contains(curr)) return;  // Important check to prevent cycles
        hs.add(curr);
        
        int index = 0;
        for (int connected : isConnected[curr]) {
            if (connected == 1 && !hs.contains(index)) {
                dfs(hs, isConnected, index);
            }
            index++;
        }
    }
}
