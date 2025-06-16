class Solution {
    public boolean isCyclic(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<V; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[V];
        for(int[] pair : edges){
            graph.get(pair[0]).add(pair[1]);
            indegree[pair[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++)if(indegree[i]==0)q.add(i);
        if(q.isEmpty()) return true;
        HashSet<Integer> vis = new HashSet<>();
        
        // HashSet<> : Space -> O(n) Time -> O(1)
        // Boolean[] : Space -> O(n) Time -> O(n)
        
        while(vis.size()!=V){
            if(q.isEmpty()) return true;
            int sz = q.size(); 
            for(int i=0;i<sz;i++){
                int curr = q.remove();
                vis.add(curr);
                for(int j : graph.get(curr)){
                    indegree[j]--;
                    if(indegree[j]==0) q.add(j);
                }
            }
        }
        return false;
    }
}

// [[1,2],[2],[3],[]]
// [0,1,2,1]

// [[],[2],[],[0],[2]]
// [1,0,2,0,0]
// 1 3 4
