import java.util.*;
public class Solution {
   public static String cycleDetection(int[][] edges, int n, int m) {
       Queue<Integer> q = new LinkedList<>();
        int par[] = new int[n+1];
        boolean vis[] = new boolean[n+1];
        vis[1] = true;
        Arrays.fill(par,-1);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] temp: edges){
            adj.get(temp[0]).add(temp[1]);
            adj.get(temp[1]).add(temp[0]);
        }
        q.add(1);
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int j : adj.get(curr)){
                if(vis[j]==true && par[curr]!=j) return "Yes";
                if(!vis[j]){
                    q.add(j);
                    vis[j] = true;
                    par[j] = curr;
                }
            }
        }
        return "No";
    }
    
}
