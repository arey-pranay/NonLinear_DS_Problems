class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode n = findChild(root, key);
        if (n == null) return root;  // If the node is not found, return the root as is
        
        // Case 1: Node has no children
        if (n.left == null && n.right == null) {
            n = null;
        }
        // Case 2: Node has only left child
        else if (n.left != null && n.right == null) {
            n.val = n.left.val;
            n.left = null;
        }
        // Case 3: Node has only right child
        else if (n.right != null && n.left == null) {
            n.val = n.right.val;
            n.right = null;
        }
        // Case 4: Node has two children
        else {
            // Find the in-order successor (leftmost node in the right subtree)
            TreeNode ans = findIS(n.right);
            // Replace the current node's value with the in-order successor's value
            n.val = ans.val;
            // Recursively delete the in-order successor node
            n.right = deleteNode(n.right, ans.val);
        }
        return root;
    }

    // Find the node with the given key in the tree
    public TreeNode findChild(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) return root;
        if (key < root.val) return findChild(root.left, key);
        return findChild(root.right, key);
    }

    // Find the in-order successor, which is the leftmost node of the right subtree
    public TreeNode findIS(TreeNode n) {
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }
}
