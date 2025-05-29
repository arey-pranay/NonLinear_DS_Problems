import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Fix 1: Build graph with correct direction (b → a)
        for (int[] pair : prerequisites) {
            int a = pair[0];
            int b = pair[1];
            graph.get(b).add(a);    // b → a
            indegree[a]++;          // a has one more prerequisite
        }

        // Start with courses that have no prerequisites
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Count of courses we can finish
        int count = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // If we visited all courses, we can finish them
        return count == numCourses;
    }
}
