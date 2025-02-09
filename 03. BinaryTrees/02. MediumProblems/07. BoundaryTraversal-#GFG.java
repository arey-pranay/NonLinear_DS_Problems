import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {

    // Helper function to collect leaf nodes
    private void addLeafNodes(Node node, ArrayList<Integer> result) {
        if (node == null)
            return;

        // If it is a leaf node, add it to the result
        if (node.left == null && node.right == null) {
            result.add(node.data);
            return;
        }

        // Recursively add leaf nodes in left and right subtree
        addLeafNodes(node.left, result);
        addLeafNodes(node.right, result);
    }

    // Helper function to collect left boundary excluding leaves
    private void addLeftBoundary(Node node, ArrayList<Integer> result) {
        if (node == null || (node.left == null && node.right == null))
            return;

        result.add(node.data);

        // If there is a left child, go left; otherwise, go right
        if (node.left != null) {
            addLeftBoundary(node.left, result);
        } else {
            addLeftBoundary(node.right, result);
        }
    }

    // Helper function to collect right boundary excluding leaves
    private void addRightBoundary(Node node, ArrayList<Integer> result) {
        if (node == null || (node.left == null && node.right == null))
            return;

        // If there is a right child, go right; otherwise, go left
        if (node.right != null) {
            addRightBoundary(node.right, result);
        } else {
            addRightBoundary(node.left, result);
        }

        // Add the node after recursion (to achieve bottom-up order)
        result.add(node.data);
    }

    // Main function for boundary traversal
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();

        if (node == null)
            return result;

        // Add root data
        result.add(node.data);

        // Add left boundary (excluding the root and leaf nodes)
        addLeftBoundary(node.left, result);

        // Add all leaf nodes
        addLeafNodes(node.left, result);
        addLeafNodes(node.right, result);

        // Add right boundary (excluding leaf nodes)
        addRightBoundary(node.right, result);

        return result;
    }
}
