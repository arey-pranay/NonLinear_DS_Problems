class Solution
{
    //Function to merge k sorted arrays.
    static class Element {
        int value;
        int row;
        int col;

        public Element(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
  public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        // Min-heap to store elements (value, row, col)
        PriorityQueue<Element> minHeap = new PriorityQueue<>(K, new Comparator<Element>() {
            public int compare(Element e1, Element e2) {
                return Integer.compare(e1.value, e2.value);
            }
        });

        // List to store the merged sorted array
        ArrayList<Integer> result = new ArrayList<>();

        // Step 1: Insert the first element of each row into the heap
        for (int row = 0; row < K; row++) {
            minHeap.offer(new Element(arr[row][0], row, 0));
        }

        // Step 2: Extract the smallest element from the heap and push the next element of that row into the heap
        while (!minHeap.isEmpty()) {
            Element e = minHeap.poll();
            result.add(e.value);

            // If there is a next element in the same row, push it into the heap
            if (e.col + 1 < K) {
                minHeap.offer(new Element(arr[e.row][e.col + 1], e.row, e.col + 1));
            }
        }

        return result;
    }
}
