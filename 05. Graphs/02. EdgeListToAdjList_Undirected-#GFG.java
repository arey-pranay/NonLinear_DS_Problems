class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<V;i++)ans.add(new ArrayList<>());
        for(int[] arr : edges) {
            int src = arr[0]; int dest = arr[1];
            ans.get(src).add(dest); ans.get(dest).add(src);
        }
        return ans;
    }
}
