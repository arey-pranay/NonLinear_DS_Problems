// import java.util.*;

// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> ans = new ArrayList<>();
//         if (root == null) return ans;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);
//         boolean flag = true;

//         while (!q.isEmpty()) {
//             int size = q.size();
//             List<Integer> temp = new ArrayList<>();

//             for (int i = 0; i < size; i++) {
//                 TreeNode node = q.poll();
//                 if (flag) {
//                     temp.add(node.val);
//                 } else {
//                     temp.add(0, node.val); // Insert at the beginning for zigzag order
//                 }
//                 if (node.left != null) q.offer(node.left);
//                 if (node.right != null) q.offer(node.right);
//             }

//             ans.add(temp);
//             flag = !flag; // Toggle the flag for zigzag direction
//         }

//         return ans;
//     }
// }




class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<TreeNode> q = new ArrayList<>();
        if(root==null) return ans;
        q.add(root);
        boolean LtoR = true;
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> l = new ArrayList<>();
            if(LtoR==true){
                for(int i=0;i<sz;i++){
                    TreeNode temp = q.remove(0);
                    l.add(temp.val);
                    if(temp.left!=null) q.add(temp.left);
                    if(temp.right!=null) q.add(temp.right);
                }
            } else {
                for(int i=sz-1;i>=0;i--){
                    TreeNode temp = q.get(i);
                    l.add(temp.val);
                }
                for(int i=0;i<sz;i++){
                    TreeNode temp = q.remove(0);
                    if(temp.left!=null) q.add(temp.left);
                    if(temp.right!=null) q.add(temp.right);
                }
            }
            LtoR = !LtoR;
            ans.add(l);
        }
        return ans;
    }
}




