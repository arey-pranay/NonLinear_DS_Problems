/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.*;
public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        inorder(root,curr);
        ans.add(curr);

        curr = new ArrayList<Integer>();
        preorder(root,curr);
        ans.add(curr);
        curr = new ArrayList<Integer>();
        postorder(root,curr);
        ans.add(curr);
        return ans;
    }
    public static void inorder(TreeNode root,List<Integer> curr){
        if(root==null) return;
        inorder(root.left,curr);
        curr.add(root.data);
        inorder(root.right,curr);
        return;
    }
     public static void preorder(TreeNode root,List<Integer> curr){
        if(root==null) return;
        curr.add(root.data);
        preorder(root.left,curr);
        preorder(root.right,curr);
        return;
    }
     public static void postorder(TreeNode root,List<Integer> curr){
        if(root==null) return;
        postorder(root.left,curr);
        postorder(root.right,curr);
        curr.add(root.data);
        return;
    }
}
