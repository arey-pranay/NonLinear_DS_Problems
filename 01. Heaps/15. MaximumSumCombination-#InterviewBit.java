import java.util.*;

public class Solution {
    public int[] solve(int[] A, int[] B, int C) {
        // Sort both arrays in descending order
        Arrays.sort(A);
        Arrays.sort(B);

        // Priority Queue to store the largest sums
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Set to avoid revisiting the same index pairs
        Set<String> visited = new HashSet<>();

        // Initially push the pair (A[0] + B[0])
        maxHeap.offer(new int[] {A[A.length - 1] + B[B.length - 1], A.length - 1, B.length - 1});
        visited.add((A.length - 1) + "," + (B.length - 1));

        // Result list to store the top C maximum sums
        List<Integer> result = new ArrayList<>();

        // Extract the top C maximum sums
        while (result.size() < C) {
            int[] current = maxHeap.poll();
            result.add(current[0]);

            // Generate the next possible sums
            int i = current[1];
            int j = current[2];

            // Check (i-1, j) -> Move to the next element in A, same element in B
            if (i - 1 >= 0 && !visited.contains((i - 1) + "," + j)) {
                maxHeap.offer(new int[] {A[i - 1] + B[j], i - 1, j});
                visited.add((i - 1) + "," + j);
            }

            // Check (i, j-1) -> Move to the next element in B, same element in A
            if (j - 1 >= 0 && !visited.contains(i + "," + (j - 1))) {
                maxHeap.offer(new int[] {A[i] + B[j - 1], i, j - 1});
                visited.add(i + "," + (j - 1));
            }
        }

        // Convert the result list to an array and return it
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example Test Case 1
        int[] A1 = {3, 2};
        int[] B1 = {1, 4};
        int C1 = 2;
        System.out.println(Arrays.toString(solution.solve(A1, B1, C1)));  // Output: [7, 6]

        // Example Test Case 2
        int[] A2 = {1, 4, 2, 3};
        int[] B2 = {2, 5, 1, 6};
        int C2 = 4;
        System.out.println(Arrays.toString(solution.solve(A2, B2, C2)));  // Output: [10, 9, 9, 8]
    }
}
