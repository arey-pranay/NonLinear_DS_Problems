class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for(int[] pair : prerequisites){
            graph.get(pair[0]).add(pair[1]);
            indegree[pair[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) if(indegree[i]==0) q.add(i);
        if(q.isEmpty()) return false;
        HashSet<Integer> vis = new HashSet<>();
        while(vis.size()!=numCourses){
            int sz = q.size();
            if(sz==0) return false;
            for(int i=0; i<sz; i++){
                int curr = q.remove();
                vis.add(curr);
                for(int j : graph.get(curr)){
                    indegree[j]--;
                    if(indegree[j] == 0) q.add(j);
                }
            }
        }
        return true;
    }
}
