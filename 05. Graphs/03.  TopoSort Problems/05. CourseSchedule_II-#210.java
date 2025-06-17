class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for(int[] pair : prerequisites){
            graph.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) if(indegree[i]==0) q.add(i);
        int[] ans = new int[numCourses];
        if(q.isEmpty()) return new int[]{};
        int index=0;
        while(!q.isEmpty()){
            int sz = q.size();
            int curr = q.remove();
            for(int j: graph.get(curr)){
                indegree[j]--;
                if(indegree[j]==0) q.add(j);
            }
            ans[index++] = curr;
        }
        if(index!=numCourses) return new int[]{};
        return ans;
    }
}
