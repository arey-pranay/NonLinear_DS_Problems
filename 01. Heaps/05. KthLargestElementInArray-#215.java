class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums) pq.add(n);
        while(k!=1){
            pq.remove();
            k--;
        }
        return pq.remove();
    }
}
