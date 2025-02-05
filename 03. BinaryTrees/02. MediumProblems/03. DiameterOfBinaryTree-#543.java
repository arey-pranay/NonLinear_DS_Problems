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
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        func(root);
        return diameter;
    }
    public int func(TreeNode root){
        if(root==null) return 0;
        int ld = func(root.left);
        int rd = func(root.right);
        diameter = Math.max(ld+rd, diameter);
        return Math.max(ld,rd) +1;
    }
}
