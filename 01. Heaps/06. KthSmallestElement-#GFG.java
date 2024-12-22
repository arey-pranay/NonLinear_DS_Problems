class Solution {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue pq = new PriorityQueue<Integer>();
        for(int i : arr)pq.add(i);
        while(k-- != 1) pq.remove();
        return (int)pq.remove();
    }
}
