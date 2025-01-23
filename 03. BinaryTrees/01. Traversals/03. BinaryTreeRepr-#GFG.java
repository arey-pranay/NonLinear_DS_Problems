
//User function Template for Java

class Solution{
    public static void createTree(Node root0, ArrayList<Integer> v ){
        // Code here
        root0.left = new Node(v.get(1));
        root0.right = new Node(v.get(2));
        root0.left.left = new Node(v.get(3));
        root0.left.right = new Node(v.get(4)); 
        root0.right.left = new Node(v.get(5));
        root0.right.right = new Node(v.get(6));
        
    }
}
