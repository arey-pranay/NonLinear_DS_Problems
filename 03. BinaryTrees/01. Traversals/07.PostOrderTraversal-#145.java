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
    public List<Integer> postorderTraversal(TreeNode root) {
        return func(root, new ArrayList<Integer>());
    }
      public ArrayList<Integer> func(TreeNode root, ArrayList<Integer> arr){
        if(root==null) return arr;
        func(root.left, arr);
        func(root.right, arr);
        arr.add(root.val);
        return arr;
    }
}
