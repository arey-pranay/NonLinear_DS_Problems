// Kruskal's Algo

// rank array of size n, fill with 0. parent array of size n, fill with i
// find(x){ if(x==par[x])return x else return par[x]=find(par[x])}
// union(a,b) parA=find(a) and parB=find(b)
// if(para=parb)make any one of them par and increase the rank of that (like, par[parB]=parA and rank[parA]++)
//if (para>parb) make par[parB] = parA, else par[parA]=parBa



class Solution {
    public int find(int x, int[] par){
        if(x==par[x]) return x;
        return par[x] = find(par[x], par);
    }
    
    public void union(int a, int b, int[] par, int[] rank){
        int parA = par[a];
        int parB = par[b];
        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++; 
        } else if(rank[parA] > rank[parB]) par[parB] = parA;
        else par[parA] = parB;
        
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] rank = new int [n];
        int[] par = new int[n];
        
        Arrays.fill(rank,0);
        for(int i =0;i<par.length;i++) par[i] = i;
            
        ArrayList<Triple> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            int[] currPoint = points[i];
            for(int j=0;j<n;j++){
                if(i==j) continue;
                int[] neigh = points[j];
                int dist = Math.abs(currPoint[0] - neigh[0]) + Math.abs(currPoint[1] - neigh[1]);
                adj.add(new Triple(i,j,dist));
            }
        }
        Collections.sort(adj);
        int sum = 0;
        int i=0;
        int count=0;
        while(count<n-1){
            Triple curr = adj.get(i++);
            int a = curr.u;
            int b = curr.v;
            int parA = find(a,par);
            int parB = find(b,par);
            if(parA != parB){
                union(a,b,par,rank);
                sum+=curr.wt;
                count++;
            }
        }
        return sum;
    }
    class Triple implements Comparable<Triple>{
        int u;
        int v;
        int wt;
        public Triple(int u,int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
     
        }
        public int compareTo(Triple a){
            return this.wt - a.wt;
        }
    }
}

