// class Solution {
//     public int makeConnected(int n, int[][] connections) {
//         if(connections.length < n-1) return -1;
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for(int i=0;i<n;i++) adj.add(new ArrayList<>());
//         for(int [] temp : connections){
//             adj.get(temp[0]).add(temp[1]);
//             adj.get(temp[1]).add(temp[0]);
//         }
//         boolean vis[] = new boolean[n];
//         int count = 0;
//         for(int i =0;i<n;i++){
//             if(vis[i]) continue;
//             dfs(vis,i,adj);
//             count++;
//         }
//         return count - 1;
//     }
//     public void dfs(boolean vis[],int curr,ArrayList<ArrayList<Integer>> graph){
//         vis[curr] = true;
//         for(int neighbour:graph.get(curr)) if(!vis[neighbour]) dfs(vis,neighbour,graph);
//     }
// }
class Solution {
    public boolean union(int ind1, int ind2, int[] parent){
        int p1 = getParent(ind1,parent);
        int p2 = getParent(ind2,parent);
        if(p1 == p2) return false;
        parent[p2] = p1;
        return true;
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        int[] parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
        int cnt = n-1;
        for(int[] p : connections){
            if(union(p[0],p[1],parent)) cnt--;
        }
        return cnt;
    }
    public int getParent(int ind, int[] parent){
        if(parent[ind] == ind) return ind;
        parent[ind] = getParent(parent[ind],parent);
        return parent[ind];
    }
}

