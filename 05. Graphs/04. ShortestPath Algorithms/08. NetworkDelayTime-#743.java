class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++) adj.add(new ArrayList<>());
        for(int[] arr : times) adj.get(arr[0]).add(new int[]{arr[1],arr[2]}); 
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int cNode = curr[0];
            int cDist = curr[1];
            for(int[] next : adj.get(cNode)){
                int nextNode = next[0];
                int nextDist = next[1];
                if(dist[cNode] + nextDist < dist[nextNode]){
                    dist[nextNode] = dist[cNode]+nextDist;
                    pq.add(next);
                } 
            }
        }
        
        int ans = dist[1];
        for(int i=2;i<n+1;i++) ans = Math.max(ans,dist[i]);
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}
