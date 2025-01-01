class MedianFinder {
    // put the smaller half elements, it will have k or k + 1 elements
    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    // put the larger half elements, it will always have k elements
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean even = true;

    public double findMedian() {
        // there are even elements, pick two elements from each half
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        // there are odd elements, pick one from the smaller half
        else
            return small.peek();
    }

    public void addNum(int num) {
        // we have even elements in total, now for the next element we need to push it into the smaller half
        // because the smaller half will have 1 more element than that in the larger half
        // we put the element into the larger half first
        // "filter" the data and find the smallest one (this is a min heap), this one should be in the smaller half
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        // we have odd elements in total, now for the next element, we need to push it into the larger half to maintain balance, so that both heaps will have k/2 elements
        // we put the element into the smaller half first
        // "filter" the data and get the largest one (this is a max heap), this one should be in the larger half
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        // notice that even is set to be true at first, since there are 0 element, and we will go to the first "if" condition
        even = !even;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
