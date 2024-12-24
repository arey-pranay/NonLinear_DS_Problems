class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        // Step 1: Create a list of pairs (value, original index)
        Integer[] originalArr = new Integer[N];
        for (int i = 0; i < N; i++) {
            originalArr[i] = arr[i];
        }
        
        // Step 2: Sort the array (with original indices) using a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(arr[i]);
        }

        // Step 3: Create an array to store the sorted elements
        int[] sorted = new int[N];
        for (int i = 0; i < N; i++) {
            sorted[i] = pq.remove();
        }
        
        // Step 4: Create a map to store the first occurrence rank of each element
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (!rankMap.containsKey(sorted[i])) {
                rankMap.put(sorted[i], rank++);
            }
        }

        // Step 5: Create an answer array and assign the ranks based on the original positions
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = rankMap.get(arr[i]);  // Get the rank for the original value
        }

        return ans;
    
}

    //         int[] sorted = new int[N];
    //         PriorityQueue<Integer> pq = new PriorityQueue<>();
    //         for(int i=0;i<N;i++){
    //             pq.add(arr[i]);
    //         }
            
    //         for(int i=0;i<N;i++){
    //             sorted[i] = pq.remove();
    //         }
    //         int max = sorted[N-1];
            
    //         int[] originals = new int[max+1];
    //         int index = 0;
    //         for(int i : arr){
    //             originals[i] = index++;
    //         }
    //         int[] ans = new int[N];
    //         //remove i from 0 to N element from PQ at a time and put the i value at the 
    //         for(int i=0;i<N;i++){
    //             ans[originals[sorted[i]]] = i+1;
    //         }
    //         return ans;
    //   }
}
     
