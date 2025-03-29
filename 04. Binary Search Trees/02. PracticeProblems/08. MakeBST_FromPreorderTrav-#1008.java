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

//  // first element of pre is root
//  // get L and R of root from inorder

// // pre = 8,5,1,7,10,12

// // root = 8 (pre[0])
// // root.left = pre[1] 
// // bstFromPreorder(pre, inFrom1to7)
// // root.right = pre[]


// class Solution {
//     int i=0;
//     public TreeNode bstFromPreorder(int[] preorder) {
//         TreeNode root = new TreeNode(preorder[0]);
//         addToLeft(preorder,1,root, null);
//     }
//     addToLeft(int[] pre, int i, TreeNode root, TreeNode parent){
//         if(pre[i] < root){
//             root.left = new TreeNode(pre[i]);
//             addToLeft(pre,++i,root.left, root);
//         } else {
//             return;
//         }

//     }
// }

class Solution {
int i = 0;
int calls = 0;
    public TreeNode bstFromPreorder(int[] arr) {
        TreeNode ans = helper(arr, Integer.MAX_VALUE);
        System.out.println(calls);
        return ans;
    }
    public TreeNode helper(int[] arr, int bound) {
        calls++;
        if(i<arr.length)System.out.println("arr[i]= "+arr[i]+" and bound = "+bound);
        if (i == arr.length || arr[i] > bound) return null;
        TreeNode root = new TreeNode(arr[i]);
        root.left = helper(arr, arr[i++]); // for arr[i] = 1, this will ret null, because, 7>1
        root.right = helper(arr, bound); // for arr[i] = 1, this will ret null, because, 7>5
        return root;
    }
	}
	
// EXPLANATON-
// "explanation- It is  possible to do this because when we construct the " left child " the upper bound will be the node value itself and no lower bound will be needed!
// 	-no lower bound is required for "right child" because we have arrived at this point of creating the right child only because these elements failed to satisfy the left subtree conditions!"
	
 
