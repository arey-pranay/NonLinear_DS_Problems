/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    int i;
    ArrayList<Integer> arr = new ArrayList<>();
    public BSTIterator(TreeNode root) {
        arr = traversal(arr,root);
    }
    public ArrayList<Integer> traversal(ArrayList<Integer> arr, TreeNode root){
        if(root==null) return arr;
        arr  = (traversal(arr,root.left));
        arr.add(root.val);
        arr = (traversal(arr,root.right));
        return arr;
    }
    public int next() {
        return arr.get(i++);
    }
    
    public boolean hasNext() {
        if(i==arr.size())return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
