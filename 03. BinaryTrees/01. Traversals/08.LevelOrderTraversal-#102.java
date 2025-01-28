// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> list = new ArrayList<>();
//         addByLevel(root, 0, list);
//         return list;
//     }

//     public static void addByLevel(TreeNode root, int level, List<List<Integer>> list) {
//         if(root == null) return;

//         if(list.size() == level) {
//             List<Integer> currlist = new ArrayList<>();
//             currlist.add(root.val);
//             list.add(currlist);
//         } else {
//             list.get(level).add(root.val);
//         }
        
//         addByLevel(root.left, level + 1, list);
//         addByLevel(root.right, level + 1, list);
//     } 
// }
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        q.add(root);
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<sz;i++){
                TreeNode temp = q.remove();
                l.add(temp.val);
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
            ans.add(l);
        }
        return ans;
    } 
}
