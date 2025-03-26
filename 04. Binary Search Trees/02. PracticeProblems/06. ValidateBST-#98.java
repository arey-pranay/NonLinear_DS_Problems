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
class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        return inorder(root,true);
    }
    public boolean inorder(TreeNode root, boolean flag){
        if(root==null) return true;
        flag &= inorder(root.left,flag);
        if(arr.size()>0) if(root.val<=arr.get(arr.size()-1)) return false;
        arr.add(root.val);
        flag &= inorder(root.right,flag);
        return flag;
    }
}
