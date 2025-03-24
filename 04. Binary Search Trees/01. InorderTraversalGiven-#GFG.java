class Solution {
    static boolean isBSTTraversal(int arr[]) {
        int curr = arr[0];
        for(int i=1;i<arr.length;i++){
            int next = arr[i];
            if(curr>=next) return false;
            curr = next;
        }
        return true;
    }
}
