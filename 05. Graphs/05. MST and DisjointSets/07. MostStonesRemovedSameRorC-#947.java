// class Solution {
//     public int removeStones(int[][] stones) {
//         int m = stones.length;
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < m; i++) adj.add(new ArrayList<>());

//         // Build adjacency list
//         for (int i = 0; i < m; i++) {
//             for (int j = i + 1; j < m; j++) {
//                 if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
//                     adj.get(i).add(j);
//                     adj.get(j).add(i);
//                 }
//             }
//         }

//         boolean[] visited = new boolean[m];
//         int components = 0;

//         for (int i = 0; i < m; i++) {
//             if (!visited[i]) {
//                 dfs(i, adj, visited);
//                 components++;
//             }
//         }
        
//         // kyuki if you do the most optimized removal, only 1 element from each component will remain

//         return m - components; // total stones - connected components
//     }

//     private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
//         visited[node] = true;
//         for (int nei : adj.get(node)) {
//             if (!visited[nei]) dfs(nei, adj, visited);
//         }
//     }
// }

class Solution {
    public int removeStones(int[][] stones) {
        //So, make a union of all the stone if they share the same row or same col and remove all but one .
        int[] parent = new int[20002];
        int OFFSET =  10001; 
        //AND MAKE THE PARENT OF EACH ONE AS SAME.
        for(int i=0;i<parent.length;i++){
            parent[i]=i; // Intialize the parent of them as them self.
        }
        for(int i=0;i<stones.length;i++){
            union(stones[i][0],stones[i][1]+OFFSET,parent);
        }
        Set<Integer> set = new HashSet<>();
        //This will be used to count the roots
        for(int i=0;i<stones.length;i++){
            set.add(find(stones[i][0],parent));
        }
        return stones.length-set.size();
    }
    public int find(int x,int[] parent){
        if(parent[x]==x){
            return x;
        }
        parent[x] = find(parent[x],parent);
        return parent[x]; 
    }
    public void union(int x,int y,int[] parent){
        int parX = find(x,parent);
        int parY = find(y,parent);
        if(parX==parY){
            return ;
        }
        //NOW WE WILL JUST UNION THIS. 
        parent[parX] = parY;
    }
}
