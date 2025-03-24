class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        if(root.left == null) return root.data;
        return minValue(root.left);
        // code here
    }
}
