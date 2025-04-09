class Solution {
    int time = -1;
    int unrotten = 0;
    Queue<int[]> q = new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) q.add(new int[] { i, j });
                if (grid[i][j] == 1) unrotten++;
            }
        }
        if(q.size()==0 && unrotten!=0) return time;
        if(q.size()==0 && unrotten==0) return 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] temp = q.remove();
                int x = temp[0];
                int y = temp[1];
                if (x != 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    unrotten--;
                    q.add(new int[] { x - 1, y });
                }
                if (y != 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    unrotten--;
                    q.add(new int[] { x, y - 1 });
                }
                if (x != grid.length - 1 && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    unrotten--;
                    q.add(new int[] { x + 1, y });
                }
                if (y != grid[0].length - 1 && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    unrotten--;
                    q.add(new int[] { x, y + 1 });
                }            
            }
            time++;
        }
        if (unrotten > 0) return -1;
        return time;
    }

    // public void rot(int x, int y, int[][] grid) {

    //     if (grid[x][y] != 1)
    //         return;
    //     unrotten--;

    //     if (unrotten == 0)
    //         return;

    //     if (x != 0 && grid[x - 1][y] == 1) {
    //         grid[x - 1][y] = 2;
    //         rot(x - 1, y, grid);
    //     }
    //     if (y != 0 && grid[x][y - 1] == 1) {
    //         grid[x][y - 1] = 2;
    //         rot(x, y - 1, grid);
    //     }
    //     if (x != grid.length - 1 && grid[x + 1][y] == 1) {
    //         grid[x + 1][y] = 2;
    //         rot(x + 1, y, grid);
    //     }
    //     if (y != grid[0].length - 1 && grid[x][y + 1] == 1) {
    //         grid[x][y + 1] = 2;
    //         rot(x, y + 1, grid);
    //     }
    //     time++;
    //     return;
    // }
}
