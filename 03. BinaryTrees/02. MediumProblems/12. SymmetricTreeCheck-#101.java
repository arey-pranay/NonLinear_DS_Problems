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
    public boolean isSymmetric(TreeNode root) {
        return root==null || func(root.left,root.right);   
    }
    public boolean func(TreeNode L, TreeNode R){
        if(L==null ^ R==null) return false; //sirf 1 hi hai valid node, mtlb structural asymmetry hai
        if(L==null && R==null) return true; //agr dono hi khaali hai, mtlb (sub-)tree khtm
        if(L.val != R.val) return false; //agr values same nhi hai, mtlb numerically asymmetric
        return func(L.left,R.right) && func(L.right,R.left); //fir return true only if both left and right subtrees are symmetrical
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return compare(root.left,root.right);
    }
    public boolean compare(TreeNode l, TreeNode r){
        if(l==null && r==null ) return true;

        if(l==null || r==null ) return false;

        return (l.val==r.val && compare(l.right,r.left) && compare(l.left,r.right));
    }
}
