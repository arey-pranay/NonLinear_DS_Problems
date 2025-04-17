class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<mat.length; i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 1) mat[i][j] = Integer.MAX_VALUE;
                else q.add(new int[]{i,j}); 
            }
        }
        int[] neighs = new int[]{-1,0,1,0,-1};
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int x = curr[0];
            int y = curr[1];
            for(int i=0;i<4;i++){
                int X = x+ neighs[i];
                int Y = y+ neighs[i+1];
                if(X==-1 || Y == -1 || X == m || Y == n) continue;
                if(mat[X][Y] > mat[x][y]+1){
                    mat[X][Y] = mat[x][y]+1;
                    q.add(new int[]{X,Y});
                }

            }
        }
        return mat;
    }
}
