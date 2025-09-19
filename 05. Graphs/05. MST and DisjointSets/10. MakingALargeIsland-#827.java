// class Solution {
//     public int largestIsland(int[][] grid) {
//         boolean vis[][] = new boolean[grid.length][grid.length];
//         int ans = Integer.MIN_VALUE;
        
//         // Step 1: Mark all land cells as 0 and water cells as -1
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid.length; j++) {
//                 if (grid[i][j] == 1) grid[i][j] = 0;
//                 else grid[i][j] = -1;
//             }
//         }

//         // Step 2: Explore and calculate the sizes of the islands
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid.length; j++) {
//                 if (grid[i][j] == 0 && !vis[i][j]) {
//                     int temp = dfs(grid, vis, i, j, 0);
//                     ans = Math.max(ans, temp);
//                     change(grid, vis, i, j, temp);
//                 }
//             }
//         }

//         // Step 3: Evaluate the largest possible island by flipping each water cell to land
//         int[] neighs = new int[]{-1, 0, 1, 0, -1};
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid.length; j++) {
//                 if (grid[i][j] == -1) {
//                     int combinedSize = 1; // We will flip this cell to land, so start with 1
//                     Set<Integer> seen = new HashSet<>();
//                     for (int k = 0; k < 4; k++) {
//                         int X = i + neighs[k];
//                         int Y = j + neighs[k + 1];
//                         if (X >= 0 && X < grid.length && Y >= 0 && Y < grid.length && grid[X][Y] != -1) {
//                             int islandId = grid[X][Y];
//                             if (!seen.contains(islandId)) {
//                                 seen.add(islandId);
//                                 combinedSize += islandId; // Add the size of this island
//                             }
//                         }
//                     }
//                     ans = Math.max(ans, combinedSize);
//                 }
//             }
//         }

//         return ans;
//     }

//     // DFS to explore the island and calculate the size
//     public int dfs(int[][] grid, boolean[][] vis, int x, int y, int count) {
//         vis[x][y] = true;
//         count++;
//         int[] neighs = new int[]{-1, 0, 1, 0, -1};
//         for (int i = 0; i < 4; i++) {
//             int X = x + neighs[i];
//             int Y = y + neighs[i + 1];
//             if (X >= 0 && X < grid.length && Y >= 0 && Y < grid.length && grid[X][Y] == 0 && !vis[X][Y]) {
//                 count = Math.max(count, dfs(grid, vis, X, Y, count));
//             }
//         }
//         return count;
//     }

//     // Track the size of islands by marking the grid with unique island IDs
//     public void change(int[][] grid, boolean[][] vis, int x, int y, int newValue) {
//         vis[x][y] = true;
//         grid[x][y] = newValue;
//         int[] neighs = new int[]{-1, 0, 1, 0, -1};
//         for (int i = 0; i < 4; i++) {
//             int X = x + neighs[i];
//             int Y = y + neighs[i + 1];
//             if (X >= 0 && X < grid.length && Y >= 0 && Y < grid.length && grid[X][Y] == 0 && !vis[X][Y]) {
//                 change(grid, vis, X, Y, newValue);
//             }
//         }
//     }
// }


class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] islandId = new int[n][n];
        int[] islandSize = new int[n * n + 2]; // to store sizes of the islands (index 0 for out of bounds)
        int currentIslandId = 2; // Island ids start from 2, as 0 and 1 are for water and land
        int maxIslandSize = 0;

        // Helper function to get the neighbors of a cell
        int[] dirs = {-1, 0, 1, 0, -1}; // Directions for top, right, bottom, left

        // First pass: Calculate island sizes and label each island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && islandId[i][j] == 0) {
                    int islandArea = dfs(grid, islandId, i, j, currentIslandId++, islandSize);
                    maxIslandSize = Math.max(maxIslandSize, islandArea);
                }
            }
        }

        // Second pass: Try to flip each 0 into a 1 and calculate the maximum island size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighboringIslands = new HashSet<>();
                    int newIslandSize = 1; // Start with the flipped cell itself

                    // Check 4 directions (up, right, down, left)
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dirs[d];
                        int nj = j + dirs[d + 1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                            int island = islandId[ni][nj];
                            if (!neighboringIslands.contains(island)) {
                                neighboringIslands.add(island);
                                newIslandSize += islandSize[island]; // Add the size of the neighboring island
                            }
                        }
                    }

                    maxIslandSize = Math.max(maxIslandSize, newIslandSize);
                }
            }
        }

        return maxIslandSize;
    }

    // DFS function to label the island and calculate its size
    private int dfs(int[][] grid, int[][] islandId, int i, int j, int currentIslandId, int[] islandSize) {
        int n = grid.length;
        islandId[i][j] = currentIslandId;
        int islandArea = 1;
        int[] dirs = {-1, 0, 1, 0, -1}; // Directions for top, right, bottom, left
        for (int d = 0; d < 4; d++) {
            int ni = i + dirs[d];
            int nj = j + dirs[d + 1];
            if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1 && islandId[ni][nj] == 0) {
                islandArea += dfs(grid, islandId, ni, nj, currentIslandId, islandSize);
            }
        }
        islandSize[currentIslandId] = islandArea; // Store the size of the island
        return islandArea;
    }
}
