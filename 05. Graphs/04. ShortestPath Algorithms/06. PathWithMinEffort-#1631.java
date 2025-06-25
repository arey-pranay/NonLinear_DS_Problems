class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        // minDiffToReach[i][j] = minimum max difference to reach cell (i, j)
        int[][] minDiffToReach = new int[n][m];
        for (int[] row : minDiffToReach) Arrays.fill(row, Integer.MAX_VALUE);
        minDiffToReach[0][0] = 0;

        // Min-heap: [currentMaxDiff, x, y]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0});

        int[] dir = {-1, 0, 1, 0, -1};

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int currentMaxDiff = top[0];
            int x = top[1];
            int y = top[2];

            // Reached destination
            if (x == n - 1 && y == m - 1) return currentMaxDiff;

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i];
                int ny = y + dir[i + 1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    int heightDiff = Math.abs(heights[nx][ny] - heights[x][y]);
                    int pathMaxDiff = Math.max(currentMaxDiff, heightDiff);

                    if (pathMaxDiff < minDiffToReach[nx][ny]) {
                        minDiffToReach[nx][ny] = pathMaxDiff;
                        pq.add(new int[]{pathMaxDiff, nx, ny});
                    }
                }
            }
        }

        return -1; // Fallback — shouldn't happen
    }
}
