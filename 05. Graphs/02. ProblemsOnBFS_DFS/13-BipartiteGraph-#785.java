// import java.util.*;

// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         HashSet<Integer> A = new HashSet<>();
//         HashSet<Integer> B = new HashSet<>();
//         int n = graph.length;
//         boolean[] visited = new boolean[n];

//         for (int i = 0; i < n; i++) {
//             if (visited[i]) continue;
//             Queue<Integer> queue = new LinkedList<>();
//             queue.offer(i);
//             A.add(i);  // Assign starting node to set A
//             while (!queue.isEmpty()) {
//                 int node = queue.poll();
//                 visited[node] = true;
//                 HashSet<Integer> own = A.contains(node) ? A : B;
//                 HashSet<Integer> other = A.contains(node) ? B : A;

//                 for (int neighbor : graph[node]) {
//                     if (own.contains(neighbor)) {
//                         return false; // Conflict: same set contains adjacent nodes
//                     }
//                     if (!other.contains(neighbor)) {
//                         other.add(neighbor);
//                         queue.offer(neighbor);
//                     }
//                 }
//             }
//         }

//         return true;
//     }
// }

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] vis=new int[n];
        Arrays.fill(vis,-1);
        for(int i=0;i<n;i++){
            if(vis[i]==-1){
                if(dfs(i,0,vis,graph)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int i,int color,int[] vis,int[][] graph){
        vis[i]=color;
        for(int el:graph[i]){
            if(vis[el]==-1){
                if(dfs(el,color^1,vis,graph)==false){
                    return false;
                }
            }else{
                if(vis[el]==color){
                    return false;
                }
            }
        }
        return true;
    }
}

// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         // bfs
//         int n = graph.length;
//         int m = graph[0].length;
//         int vis[] = new int[n];
//         Arrays.fill(vis, -1);

//         for (int i = 0; i < n; i++) {
//             if (vis[i] == -1) { // not visited
//                 if (!color(graph, vis, i)) {
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }

//     public boolean color(int[][] graph, int[] vis, int node) {
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(node);
//         vis[node] = 0; // given color = 0

//         while (!q.isEmpty()) {
//             int curr = q.poll();
//             for (int neighbour : graph[curr]) {
//                 if (vis[neighbour] == -1) { // not vis
//                     vis[neighbour] = 1 - vis[curr];
//                     q.offer(neighbour);
//                 } else if (vis[neighbour] == vis[curr]) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
// }
