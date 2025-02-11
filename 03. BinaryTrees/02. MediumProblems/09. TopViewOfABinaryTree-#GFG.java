
/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        tm.put(0,root.data);
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root,0));
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                Info curr = q.remove();
                if(!tm.containsKey(curr.level))tm.put(curr.level,curr.node.data);
                if(curr.node.left!=null)q.add(new Info(curr.node.left, curr.level-1));
                if(curr.node.right!=null)q.add(new Info(curr.node.right, curr.level+1));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e : tm.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }
    static class Info{
        Node node;
        int level;
        Info(Node n, int l){
            this.node = n;
            this.level = l;
        }
    }
}
