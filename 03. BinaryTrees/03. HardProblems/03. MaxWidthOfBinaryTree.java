// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public int widthOfBinaryTree(TreeNode root) {
//         int ans = 0;
//         Queue<Info> q = new LinkedList<>();
//         q.add(new Info(root,0));
//         while(!q.isEmpty()){
//             int sz = q.size();
//             int minV = Integer.MAX_VALUE;
//             int maxV = Integer.MIN_VALUE;
//             boolean flagToEnd = true;
//             int nums = 0;
//             int start = -1;
//             int end = -1;
//             for(int i=0;i<sz;i++){
//                 Info remv = q.remove();
//                 if(remv.node.val != -1 && start==-1) start = i;
//                 else if(remv.node.val != -1) end = i;
//                 minV = Math.min(minV,remv.level);
//                 maxV = Math.max(maxV,remv.level);
//                 if(remv.node.left != null){
//                     q.add(new Info(remv.node.left,remv.level-1));
//                     flagToEnd = false;
//                 }
//                 else q.add(new Info(new TreeNode(-1),remv.level-1));
//                 if(remv.node.right != null){
//                     q.add(new Info(remv.node.right,remv.level+1));
//                     flagToEnd = false;
//                 }
//                 else q.add(new Info(new TreeNode(-1),remv.level+1));
//             }
//             ans = Math.max(ans, end-start+1);
//             if(flagToEnd==true)break;
//         }
//         return ans == 0 ? 1 : ans;
//     }
//     class Info{
//         TreeNode node;
//         int level;
//         Info(TreeNode n, int l){
//             this.node = n;
//             this.level  = l;
//         }
//     }
// }

import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int ans = 0;
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0L)); // Using long to avoid overflow
        
        while (!q.isEmpty()) {
            int sz = q.size();
            long start, end;
            for (int i = 0; i < sz; i++) {
                Info remv = q.poll();
                TreeNode node = remv.node;
                long index = remv.index;
                if (i == 0) start = index; // First node in level
                if (i == sz - 1) end = index; // Last node in level                
                if (node.left != null) q.add(new Info(node.left, 2 * index));
                if (node.right != null) q.add(new Info(node.right, 2 * index + 1));
            }
            ans = Math.max(ans, (int) (end - start + 1));
        }
        return ans;
    }

    class Info {
        TreeNode node;
        long index;
        Info(TreeNode n, long i) {
            this.node = n;
            this.index = i;
        }
    }
}
