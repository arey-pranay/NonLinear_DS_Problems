class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0)
            return true;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                q.add(i);
        if (q.isEmpty())
            return false;
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int j : graph.get(curr)) {
                indegree[j]--;
                if (indegree[j] == 0)
                    q.add(j);
            }
            count++;
        }
        return count == numCourses;
    }
}
