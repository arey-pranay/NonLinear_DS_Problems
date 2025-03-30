class Solution {
    // Method to find the size of largest BST in a binary tree
    static int largestBst(Node root) {
        return largestBSTSubtree(root).size;
    }
    
    // Helper class to store information about subtrees
    static class NodeInfo {
        int size;       // Size of the subtree
        int min;        // Minimum value in the subtree
        int max;        // Maximum value in the subtree
        boolean isBST;  // Whether the subtree is a valid BST
        
        NodeInfo(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
    
    // Process each node post-order and determine if subtree is a valid BST
    static NodeInfo largestBSTSubtree(Node root) {
        // Base case: null node is a BST of size 0
        if (root == null) {
            return new NodeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        
        // Get information from left and right subtrees
        NodeInfo left = largestBSTSubtree(root.left);
        NodeInfo right = largestBSTSubtree(root.right);
        
        // Current node is a BST if:
        // 1. Left subtree is a BST
        // 2. Right subtree is a BST
        // 3. Current node's value > max value in left subtree
        // 4. Current node's value < min value in right subtree
        if (left.isBST && right.isBST && 
            root.data > left.max && root.data < right.min) {
            
            // Current subtree is a valid BST
            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);
            int size = 1 + left.size + right.size;
            
            return new NodeInfo(size, min, max, true);
        } else {
            // Current subtree is not a BST, so return the size of the largest BST found
            int maxSize = Math.max(left.size, right.size);
            return new NodeInfo(maxSize, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        }
    }
}
