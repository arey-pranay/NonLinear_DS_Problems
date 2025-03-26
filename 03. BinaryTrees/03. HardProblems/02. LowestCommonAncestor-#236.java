class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)  return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;
        
        return root;
    }

}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     ArrayList<ArrayList<TreeNode>> arrs = new ArrayList<>();
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         inorder(root,p,q,new ArrayList<>());
//         return compare(arrs);
//     }
//     void inorder(TreeNode root, TreeNode x, TreeNode y, ArrayList<TreeNode> arr){
//         if(arrs.size()==2) return;
//         arr.add(root);
//         if(root.val == x.val || root.val == y.val) arrs.add(new ArrayList<>(arr));
//         if(root.left!=null) inorder(root.left,x,y,arr);
//         if(root.right!=null) inorder(root.right,x,y,arr);
//         arr.remove(arr.size()-1);
//     }
//     TreeNode compare(ArrayList<ArrayList<TreeNode>> arrs){
//         TreeNode ans = null;
//         ArrayList<TreeNode> arr1 = arrs.get(0);
//         ArrayList<TreeNode> arr2 = arrs.get(1);
//         HashSet<Integer> hs = new HashSet<>();
//         for(TreeNode t : arr1) hs.add(t.val);
//         for(TreeNode t : arr2) if(hs.contains(t.val)) ans = t;
//         return ans;
//     }
   
// }

// class Solution {
//     // Remove the unnecessary creation of `arrs` inside the method
//     ArrayList<ArrayList<TreeNode>> arrs = new ArrayList<>();

//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         inorder(root, p, q, new ArrayList<>());
//         return compare(arrs);
//     }

//     // Optimized inorder traversal to stop early if both lists are found
//     void inorder(TreeNode root, TreeNode x, TreeNode y, ArrayList<TreeNode> arr) {
//         if (arrs.size() == 2) return;  // stop recursion if both lists are found
//         if (root == null) return;  // avoid null check after recursive calls

//         arr.add(root);  // Add the current node

//         // If current node is either x or y, store the path
//         if (root.val == x.val || root.val == y.val) {
//             arrs.add(new ArrayList<>(arr));
//             if (arrs.size() == 2) return;  // Early exit when both nodes are found
//         }

//         inorder(root.left, x, y, arr);  // Traverse left subtree
//         inorder(root.right, x, y, arr); // Traverse right subtree

//         arr.remove(arr.size() - 1);  // Backtrack
//     }

//     // Compare both lists and return the LCA
//     TreeNode compare(ArrayList<ArrayList<TreeNode>> arrs) {
//         ArrayList<TreeNode> arr1 = arrs.get(0);
//         ArrayList<TreeNode> arr2 = arrs.get(1);
//         TreeNode ans = null;
//         int i = 0;
        
//         // Compare both lists for common nodes
//         while (i < arr1.size() && i < arr2.size() && arr1.get(i) == arr2.get(i)) ans = arr1.get(i++);
//         return ans;
//     }
// }
