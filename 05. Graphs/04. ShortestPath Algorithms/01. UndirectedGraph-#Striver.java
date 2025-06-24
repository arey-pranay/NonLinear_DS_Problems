class Solution {
    public int[] shortestPath(int[][] edges, int N, int M) {
        int distances[] = new int[N];
         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
         for(int i =0;i<N;i++){
            graph.add(new ArrayList<>());
         }

         for(int []pair:edges){
            int src = pair[0];
            int dest = pair[1];
            graph.get(src).add(dest);
            graph.get(dest).add(src);
         }
         
         Arrays.fill(distances,Integer.MAX_VALUE);
         distances[0] = 0;
         Queue<Integer> q = new LinkedList<>();
         q.add(0);
         while(!q.isEmpty()){
            int curr = q.remove();
            for(int neighbour:graph.get(curr)){
                if(distances[curr]+1<distances[neighbour]){
                    distances[neighbour] = distances[curr]+1;
                    q.add(neighbour);
                }
            }
         }
         for(int i = 0;i<N;i++){
            if(distances[i]==Integer.MAX_VALUE){
                distances[i] = -1;
            }
         }
         return distances;
    }
}
