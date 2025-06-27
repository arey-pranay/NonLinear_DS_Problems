// class Solution {
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         List<List<int[]>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
//         for (int[] node : flights) adj.get(node[0]).add(new int[]{node[1], node[2]});

//         Queue<int[]> pq = new LinkedList<>();
//         pq.add(new int[]{src, 0, 0}); // [node, totalCost, level]

//         List<List<List<Integer>>> dist = new ArrayList<>();
//         for (int i = 0; i < n; i++) dist.add(new ArrayList<>());
//         dist.get(src).add(Arrays.asList(0, 0)); // cost, level

//         while (!pq.isEmpty()) {
//             int[] curr = pq.remove();
//             int currNode = curr[0];
//             int currCost = curr[1];
//             int currLevel = curr[2];
//             int nextLevel = currLevel + 1;

//             for (int[] neighbour : adj.get(currNode)) {
//                 int nextNode = neighbour[0];
//                 int nextCost = neighbour[1];
//                 int totalCost = currCost + nextCost;

//                 if (currLevel == k && nextNode != dst) continue;

//                 boolean shouldAdd = true;
//                 for (List<Integer> state : dist.get(nextNode)) {
//                     int recordedCost = state.get(0);
//                     int recordedLevel = state.get(1);
//                     if (recordedLevel <= nextLevel && recordedCost <= totalCost) {
//                         shouldAdd = false;
//                         break;
//                     }
//                 }

//                 if (shouldAdd) {
//                     dist.get(nextNode).add(Arrays.asList(totalCost, nextLevel));
//                     pq.add(new int[]{nextNode, totalCost, nextLevel});
//                 }
//             }
//         }

//         int ans = Integer.MAX_VALUE;
//         for (List<Integer> state : dist.get(dst)) {
//             ans = Math.min(ans, state.get(0));
//         }

//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
// }


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for(int i = 0; i <= k; i++)
            if(isBellMannFordComplete(flights, cost))
                break;

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];        
    }

    private boolean isBellMannFordComplete(int[][] flights, int[] cost){
        boolean complete = true;
        int[] temp = cost.clone();
        for(int[] flight : flights){
            int u = flight[0],
                v = flight[1],
                price = flight[2];

            if(temp[u] == Integer.MAX_VALUE)
                continue;

            if(temp[u] + price < cost[v]){
                cost[v] = temp[u] + price;
                complete = false;
            }
        }
        return complete;
    }
}
