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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int level = 0;
        List<Info> l = new ArrayList<>();
        Info i0 = new Info(root, 0);
        Queue<Info> q = new LinkedList<>();
        q.add(i0);
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                Info iN = q.remove();
                l.add(iN);
                if(iN.node.left != null){
                    q.add(new Info(iN.node.left, iN.level-1));
                }
                if(iN.node.right != null){
                    q.add(new Info(iN.node.right, iN.level+1));
                }
            }
        }
        Collections.sort(l);
    
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(l.get(0).node.val);
        for(int i=1;i<l.size();i++){
            if(l.get(i).level != l.get(i-1).level){
                ret.add(temp);
                temp = new ArrayList<>();
            }
            temp.add(l.get(i).node.val);
        }
        if(!temp.isEmpty())ret.add(temp);
        return ret;
    }
    class Info implements Comparable<Info>{
        TreeNode node;
        int level;
        Info(TreeNode n, int l){
            this.node = n;
            this.level = l;
        }
        @Override
        public int compareTo(Info i1){
            return this.level - i1.level;
        }
    }
}

