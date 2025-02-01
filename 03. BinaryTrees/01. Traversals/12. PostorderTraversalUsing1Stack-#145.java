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

//--------------------------------Recursive------------------------------------- 
// class Solution {
//     static void postOrderTrav(TreeNode curr, List<Integer> list) {
//         if(curr == null) {
//             return;
//         }

//         postOrderTrav(curr.left, list);
//         postOrderTrav(curr.right, list);
//         list.add(curr.val);
//     }
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();

//         postOrderTrav(root, list);

//         return list;
//     }
// }


//--------------------------------Iterative(2-Stack)-------------------------------------

// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         if(root == null) {
//             return ans;
//         }

//         Stack<TreeNode> s1 = new Stack<>();
//         Stack<TreeNode> s2 = new Stack<>();

//         s1.push(root);
//         while(!s1.isEmpty()) {
//             root = s1.pop();
//             s2.push(root);

//             if(root.left != null) {
//                 s1.push(root.left);
//             }
//             if(root.right != null) {
//                 s1.push(root.right);
//             }
//         }

//         while(!s2.isEmpty()) {
//             root = s2.pop();
//             ans.add(root.val);
//         }

//         return ans;
//     }
// }


//--------------------------------Iterative(1-Stack)-------------------------------------

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();

        TreeNode current = root;

        Stack<TreeNode> stack = new Stack<>();

        while(current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.add(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if(temp == null) {
                    temp = stack.pop();
                    postOrder.add(temp.val);
                    while(!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        postOrder.add(temp.val);
                    }
                } else {
                    current = temp;
                }
            }
        }
        return postOrder;
    }
}
