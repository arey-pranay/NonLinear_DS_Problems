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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        func(root, null, val);
        return root;
    }
    public void func(TreeNode root, TreeNode par, int x){
        if(root==null) {
            if(x < par.val) par.left = new TreeNode(x);
            else par.right = new TreeNode(x);
            return;
        }
        if(x < root.val) func(root.left,root,x);
        else func(root.right,root,x);
    }
}
