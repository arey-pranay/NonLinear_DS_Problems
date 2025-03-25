class Solution {
     int[] ans = new int[]{Integer.MAX_VALUE, -1};
    public  int floor(Node root, int x) {
        if(root==null) return ans[1];
        int diff = x-root.data; //+ve diff mtlb x bada hai
        //diff must be minimized, but still be +ve
        if(diff==0) return x;
        if(diff > 0){
            if(diff < ans[0]){
                ans[0] = diff;
                ans[1] = root.data;
            }
            return floor(root.right, x);
        }
        return floor(root.left, x);
    }
}
