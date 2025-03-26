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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }
}

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         ArrayList<TreeNode> arr1 = new ArrayList<>();
//         ArrayList<TreeNode> arr2 = new ArrayList<>();
//         arr1 = findPath(root,p,arr1);
//         arr2 = findPath(root,q,arr2);
//         for(TreeNode i : arr1)System.out.print(i.val);
//         System.out.println();
//         for(TreeNode i : arr2)System.out.print(i.val);
//         HashSet<Integer> hs = new HashSet<>();
//         for(TreeNode i:arr2) hs.add(i.val);
//         for(int i = arr1.size()-1;i>=0;i--) if(hs.contains(arr1.get(i).val)) return arr1.get(i);
//         return new TreeNode(-1);
//     }
//     public ArrayList<TreeNode> findPath(TreeNode root, TreeNode target, ArrayList<TreeNode> arr){
//         arr.add(root);
//         if(root.val == target.val) return arr;
//         if(root.left!=null) findPath(root.left,target,arr);
//         if(root.right!=null) findPath(root.right,target,arr);
//         if(arr.get(arr.size()-1).val!=target.val) 
//         arr.remove(arr.size()-1);
//         return arr;
//     }

// }


