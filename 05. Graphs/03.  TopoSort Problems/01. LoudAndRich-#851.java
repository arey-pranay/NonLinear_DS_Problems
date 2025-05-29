
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ArrayList<ArrayList<Integer>> neighs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighs.add(new ArrayList<>());
        }
        
        // Fix: reverse the edge direction
        // kahan se kahan ja skte hai, less money to more money graph.
        for (int[] pair : richer) {
            neighs.get(pair[1]).add(pair[0]);
        }

        int[] ans = new int[n];
        
        Arrays.fill(ans, -1);
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, neighs, quiet, ans, visited);
            }
        }

        return ans;
    }

    private void dfs(int curr, ArrayList<ArrayList<Integer>> neighs, int[] quiet, int[] ans, boolean[] visited) {
        visited[curr] = true;
        ans[curr] = curr;

        for (int neighbor : neighs.get(curr)) {
            if (!visited[neighbor]) {
                dfs(neighbor, neighs, quiet, ans, visited);
            }

            if (quiet[ans[neighbor]] < quiet[ans[curr]]) {
                ans[curr] = ans[neighbor];
            }
        }
    }
}
