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
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(arr,root);
        int i1 = ftb(arr);
        int i2 = btf(arr);
        findAndSwap(i1,i2,root);
        return;
    }
    public void inorder(ArrayList<Integer> arr,TreeNode root){
        if(root==null) return;
        inorder(arr,root.left);
        arr.add(root.val);
        inorder(arr,root.right);
        return;
    }
    public int ftb(ArrayList<Integer> arr){
        int curr=-1;
        for(int i=0;i<arr.size()-1;i++){
            curr = arr.get(i);
            if(curr>arr.get(i+1)) return curr;
        }
        return curr;
    }
    public int btf(ArrayList<Integer> arr){
        int curr=-1;
        for(int i=arr.size()-1;i>0;i--){
            curr = arr.get(i);
            if(curr<arr.get(i-1)) return curr;
        }
        return curr;
    }
    public void findAndSwap(int a, int b, TreeNode root){
        if(root==null) return;
        if(root.val == a) root.val =b;
        else if(root.val == b) root.val =a;
        findAndSwap(a,b,root.left);
        findAndSwap(a,b,root.right);
        return;
    }
}
