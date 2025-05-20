class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // traversing first and last column
        for(int i=0;i<m;i++){
            if(grid[i][0] == 1) func(grid,i,0);
            if(grid[i][n-1] == 1) func(grid,i,n-1);
        }

        // traversing first and last row
        for(int j=0;j<n;j++){
            if(grid[0][j] == 1) func(grid,0,j);
            if(grid[m-1][j] == 1) func(grid,m-1,j);
        }

        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) count++;
            }
        }
        return count;
    }

    public void func(int[][] grid, int x, int y){
        if(x==grid.length || x==-1 || y==grid[0].length || y==-1 || grid[x][y] == 0 || grid[x][y] == 2) return;
        grid[x][y] = 2;
        int[] neighs = new int[]{-1,0,1,0,-1};
        for(int i=0; i< 4; i++){
            int X = x+neighs[i];
            int Y = y+neighs[i+1];
            func(grid,X,Y);
        }     
    }
}
