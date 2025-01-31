class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        return postOrder(root);
    }
    public static List<Integer> postOrder(TreeNode root) {
        // List to store postorder traversal
        List<Integer> postorder = new ArrayList<>();

        // If the tree is empty, return an empty traversal
        if (root == null) {
            return postorder;
        }

        // Two stacks for iterative traversal
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        // Push the root TreeNode onto the first stack
        st1.push(root);

        // Iterative traversal to populate st2 with TreeNodes in postorder
        while (!st1.empty()) {
            // Get the top TreeNode from st1
            root = st1.pop();

            // Push the TreeNode onto st2
            st2.push(root);

            // Push left child onto st1 if exists
            if (root.left != null) {
                st1.push(root.left);
            }

            // Push right child onto st1 if exists
            if (root.right != null) {
                st1.push(root.right);
            }
        }

        // Populate the postorder traversal list by popping st2
        while (!st2.empty()) {
            postorder.add(st2.pop().val);
        }

        // Return the postorder traversal
        return postorder;
    }
}
