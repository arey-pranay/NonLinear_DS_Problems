class Solution{
    public  int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
       int[] dist = new int[V];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[S] = 0;
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{S, 0});
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            for(ArrayList<Integer> neigh : adj.get(curr[0])){
                int node = neigh.get(0);
                int x = neigh.get(1);
                if(dist[curr[0]] + x < dist[node]){
                    dist[node] = dist[curr[0]] + x;
                    pq.add(new int[]{node, dist[node]});
                }
            }
        }
        for(int i=0;i<V;i++) if(dist[i]==Integer.MAX_VALUE) dist[i]=-1;
        return dist;
    }
}
