// we need all pair shortest path, so we need to use floyd warshall algorithm (fw)
// we will have an n*n matrix, where mat[i][j] will tell the min dist to go from i to j
// initially, we will fill the fw with Integer.MAX_VALUE, then we will use given adjacency list to fill fw, then we will mark the diagonal values as '0'
// then we'll use an O(v^3) loop for currNode = 0 to n, i= 0 to n, j = 0 to n. fw[i][j] = Math.min(fw[i][j], fw[i][currNode]+fw[currNode[j]])
// traverse fw and see for how many values of i, fw[i][j] is less than thresholdDistance, do ansArray[i]++,, then basic comparison logic to get the ans value

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] fw = new int[n][n];
        for(int i = 0;i<n;i++) for(int j = 0;j<n;j++) fw[i][j]=Integer.MAX_VALUE;   
        for(int[] edge : edges){
            fw[edge[0]][edge[1]] = edge[2];
            fw[edge[1]][edge[0]] = edge[2];
        }
        for(int i =0;i<n;i++) fw[i][i]=0;
        for(int currNode = 0; currNode<n; currNode++)for(int i=0;i<n;i++)for(int j=0;j<n;j++){
            if(fw[i][currNode]!=Integer.MAX_VALUE && fw[currNode][j]!=Integer.MAX_VALUE) // if we add any number to Integer.MXA_VALUE, then it overflows positive integer buffer, and goes into negative values;
            fw[i][j] = Math.min(fw[i][j],fw[i][currNode]+fw[currNode][j]);
        }
        int[] ansArray = new int[n];
        Arrays.fill(ansArray,0);
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) if(fw[i][j] <= distanceThreshold && fw[i][j]!=0) ansArray[i]++; 
        int minDist = Integer.MAX_VALUE;
        int ans = -1;
        for(int i=0;i<n;i++)
            if(ansArray[i] <= minDist){
                minDist = ansArray[i];
                ans = i;
            }
        return ans;
    }
    
}
