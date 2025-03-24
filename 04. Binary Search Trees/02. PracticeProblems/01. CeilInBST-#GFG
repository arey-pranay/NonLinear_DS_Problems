class Tree {
    // Function to return the ceil of given number in BST.
    int[] ans = new int[]{Integer.MAX_VALUE,-1}; //0 for diff, 1 for value

    int findCeil(Node root, int key) {
        
        if (root == null) return ans[1];
        int diff = root.data - key;
        
        if(diff==0) return key;
        
        if(diff > 0){
            if(diff < ans[0]){
                ans[0] = diff;
                ans[1] = root.data;
            }
            return findCeil(root.left,key);
        } 
        
        return findCeil(root.right, key);
    }
}
