class Solution {
    static void heapify(int[] arr, int i){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int largest = i;
        if(left<arr.length && arr[left] > arr[largest]) largest = left;
        if(right<arr.length && arr[right] > arr[largest]) largest = right;
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, largest);
        }
        return;
    }
    static void convertMinToMaxHeap(int N, int arr[]) {
        //start from the first non-leaf node, and heapify it according to the max logic
        for(int i=(N-1)/2 ; i>=0 ; i--){
            heapify(arr, i);
        }
    }
}
