class BinaryTree {
    // Node class representing each node of the tree
    static class Node {
        int data;
        Node left, right;
        
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to perform all three traversals based on input
    static void traverse(Node root, String traversalType) {
        if (root == null) {
            return;
        }

        switch (traversalType.toLowerCase()) {
            case "preorder":
                System.out.print(root.data + " ");
                traverse(root.left, traversalType);
                traverse(root.right, traversalType);
                break;
            case "inorder":
                traverse(root.left, traversalType);
                System.out.print(root.data + " ");
                traverse(root.right, traversalType);
                break;
            case "postorder":
                traverse(root.left, traversalType);
                traverse(root.right, traversalType);
                System.out.print(root.data + " ");
                break;
            default:
                System.out.println("Invalid traversal type. Please choose 'preorder', 'inorder', or 'postorder'.");
        }
    }

    public static void main(String[] args) {
        // Example Binary Tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Preorder Traversal:");
        traverse(root, "preorder");

        System.out.println("\nInorder Traversal:");
        traverse(root, "inorder");

        System.out.println("\nPostorder Traversal:");
        traverse(root, "postorder");
    }
}
