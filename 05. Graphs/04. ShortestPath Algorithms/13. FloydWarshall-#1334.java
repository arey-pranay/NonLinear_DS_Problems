class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] fw = new int[n][n];
        for(int i = 0;i<n;i++) for(int j = 0;j<n;j++) fw[i][j]=100000; 
        for(int[] edge : edges){
            fw[edge[0]][edge[1]] = edge[2];
            fw[edge[1]][edge[0]] = edge[2];
        }
        for(int i =0;i<n;i++) fw[i][i]=0;
        for(int currNode = 0; currNode<n; currNode++)for(int i=0;i<n;i++)for(int j=0;j<n;j++)fw[i][j] = Math.min(fw[i][j],fw[i][currNode]+fw[currNode][j]);
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

