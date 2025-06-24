// class Solution {
//     public int shortestPathBinaryMatrix(int[][] grid) {
//         LinkedHashMap<String, ArrayList<String>> adj = new LinkedHashMap<>();
//         int N = grid.length;

//         if(N==1 && grid[0][0]==1) return -1;

//         HashMap<String, Integer> dist = new HashMap<>();
//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < N; j++) {
//                 String s = String.format("%02d%02d", i, j);  // padded key
//                 adj.put(s, getNeighbours(s, grid));
//                 dist.put(s, Integer.MAX_VALUE);
//             }
//         }

//         dist.put("0000", 1);  // start point with padded key
//         Queue<String> q = new LinkedList<>();
//         q.add("0000");

//         while (!q.isEmpty()) {
//             String curr = q.remove();
//             for (String neigh : adj.get(curr)) {
//                 if (dist.get(curr) + 1 < dist.get(neigh)) {
//                     dist.put(neigh, dist.get(curr) + 1);
//                     q.add(neigh);
//                 }
//             }
//         }

//         String last = String.format("%02d%02d", N - 1, N - 1);
//         return dist.get(last) == Integer.MAX_VALUE ? -1 : dist.get(last);
//     }

//     public ArrayList<String> getNeighbours(String s, int[][] grid) {
//         int N = grid.length;
//         int M = grid[0].length;

//         int i0 = Integer.parseInt(s.substring(0, 2));
//         int i1 = Integer.parseInt(s.substring(2, 4));

//         ArrayList<String> neighbours = new ArrayList<>();
//         if (grid[i0][i1] == 1) return neighbours;

//         int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
//         int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

//         for (int k = 0; k < 8; k++) {
//             int ni = i0 + dx[k];
//             int nj = i1 + dy[k];
//             if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
//                 if (grid[ni][nj] == 0)
//                     neighbours.add(String.format("%02d%02d", ni, nj));  // padded neighbor
//             }
//         }

//         return neighbours;
//     }
// }


class cell{
    int x,y,count;
    cell(int x,int y,int count){
        this.x=x;
        this.y=y;
        this.count=count;
    }

}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        if(grid[0][0]==1||grid[r-1][c-1]==1) return -1;
        Queue<cell> queue=new LinkedList<>();
        queue.add(new cell(0,0,1));
        grid[0][0]=1;
        int[] dirx={-1,-1,-1,0,0,1,1,1};
        int[] diry={-1,0,1,-1,1,-1,0,1};
        while(!queue.isEmpty()){
            cell obj=queue.poll();
            if(obj.x==r-1 && obj.y==c-1){
                return obj.count;
            }
            for(int i=0;i<8;i++){
                int newx=dirx[i]+obj.x;
                int newy=diry[i]+obj.y;
                if(newx>=0 && newx<r && newy>=0 && newy<c && grid[newx][newy]==0){
                    queue.add(new cell(newx,newy,obj.count+1));
                    grid[newx][newy]=1;
                }
            }
        }
        return -1;
    }
}
