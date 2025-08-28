class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            int[] currPoint = points[i];
            ArrayList<Pair> temp = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(i==j) continue;
                int[] neigh = points[j];
                int dist = Math.abs(currPoint[0] - neigh[0]) + Math.abs(currPoint[1] - neigh[1]);
                temp.add(new Pair(j,dist));
            }
            adj.add(temp);
        }
        boolean[] visited = new boolean[points.length];
        Arrays.fill(visited,false);

        PriorityQueue<Combo> pq = new PriorityQueue<>(); 
        
        // ArrayList<int[]> mst = new ArrayList<>();
        
        int sum = 0;
        
        pq.add(new Combo(0,0,-1));
        
  
        while(!pq.isEmpty()){
            Combo curr = pq.poll();
            int currNode = curr.node;
            int currWt = curr.wt;
            int currPar = curr.parent;
            if(!visited[currNode]){
                visited[currNode] = true;
                sum += currWt;
                mst.add(new int[]{currNode, currPar});
                for(Pair neigh : adj.get(currNode)){
                    if(visited[neigh.node]) continue;
                    pq.add(new Combo(neigh.node, neigh.wt, currNode));
                    mst.add(new int[]{neigh.node, currNode});
                }
            }
        }
        for(int[] temp : mst) System.out.println(temp[0] + " " +temp[1]);
        return sum;   
    }
}
class Combo implements Comparable<Combo>{
    int node;
    int wt;
    int parent;
    public Combo(int node , int wt , int parent){
        this.wt = wt;
        this.node = node;
        this.parent = parent;
    }
    
    public int compareTo(Combo a){
        return this.wt - a.wt;
    }
}

class Pair{
    int node;
    int wt;
    public Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}
