class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] flag = new boolean[adj.size()];
        q.add(0);
        ans.add(0);
        flag[0] = true;
        // while(ans.size() != adj.size()){
            while(!q.isEmpty()){
                int curr = q.remove();
                for(int i : adj.get(curr)){
                    if(flag[i] == true) continue;
                    q.add(i);
                    ans.add(i);
                    flag[i] = true;
                }
            }
        // }
        return ans;
    }
}
