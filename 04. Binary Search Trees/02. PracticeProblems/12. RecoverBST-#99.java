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
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        inorder(arr,root);
        TreeNode i1 = findInArr(arr,true);
        TreeNode i2 = findInArr(arr,false);
        int temp = i1.val;
        i1.val = i2.val;
        i2.val = temp;
        return;
    }
    public void inorder(ArrayList<TreeNode> arr,TreeNode root){
        if(root==null) return;
        inorder(arr,root.left);
        arr.add(root);
        inorder(arr,root.right);
        return;
    }
    public TreeNode findInArr(ArrayList<TreeNode> arr, boolean front){
        TreeNode curr= new TreeNode(-1);
        if(front == true){
            for(int i=0;i<arr.size()-1;i++){
                curr = arr.get(i);
                if(curr.val>arr.get(i+1).val) return curr;
            }
            return curr;
        }
        for(int i=arr.size()-1;i>0;i--){
            curr = arr.get(i);
            if(curr.val<arr.get(i-1).val) return curr;
        }
        return curr;
    }
}
