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
