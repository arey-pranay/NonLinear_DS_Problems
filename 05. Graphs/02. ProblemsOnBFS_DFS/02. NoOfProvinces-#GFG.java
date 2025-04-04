class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V]; // Using boolean array instead of HashSet
        int count = 0;
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    visited[curr] = true;
                    
                    for (int j = 0; j < V; j++) {
                        if (adj.get(curr).get(j) == 1 && !visited[j] && j != curr) {
                            q.add(j);
                        }
                    }
                }
            }
        }
        return count;
    }
}
