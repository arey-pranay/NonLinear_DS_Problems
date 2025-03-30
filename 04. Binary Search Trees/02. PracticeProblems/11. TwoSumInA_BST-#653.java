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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(arr,root);
        int s = 0;
        int e = arr.size()-1;
        while(s<e){
            int sum = arr.get(s)+arr.get(e);
            if(sum < k) s++;
            else if(sum > k) e--;
            else return true;
        }
        return false;
    }
    public void inorder(ArrayList<Integer> arr, TreeNode root){
        if(root==null) return;
        inorder(arr, root.left);
        arr.add(root.val);
        inorder(arr, root.right);
        return;
    }
}
