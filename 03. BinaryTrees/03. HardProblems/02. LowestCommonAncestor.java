/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayList<ArrayList<TreeNode>> arrs = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        inorder(root,p,q,new ArrayList<>());
        return compare(arrs);
    }
    void inorder(TreeNode root, TreeNode x, TreeNode y, ArrayList<TreeNode> arr){
        if(arrs.size()==2) return;
        arr.add(root);
        if(root.val == x.val || root.val == y.val) arrs.add(new ArrayList<>(arr));
        if(root.left!=null) inorder(root.left,x,y,arr);
        if(root.right!=null) inorder(root.right,x,y,arr);
        arr.remove(arr.size()-1);
    }
    TreeNode compare(ArrayList<ArrayList<TreeNode>> arrs){
        TreeNode ans = null;
        ArrayList<TreeNode> arr1 = arrs.get(0);
        ArrayList<TreeNode> arr2 = arrs.get(1);
        HashSet<Integer> hs = new HashSet<>();
        for(TreeNode t : arr1) hs.add(t.val);
        for(TreeNode t : arr2) if(hs.contains(t.val)) ans = t;
        return ans;
    }
   
}
