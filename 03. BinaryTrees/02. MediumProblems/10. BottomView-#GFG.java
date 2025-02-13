class Solution{
    //bottom view java code for the gfg questio
    public ArrayList <Integer> bottomView(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> hm = new TreeMap<>(); // col : node
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                Pair temp = q.remove();
                Node tempNode = temp.n;
                hm.put(temp.col,tempNode.data);
                if(tempNode.left!=null)q.add(new Pair(tempNode.left, temp.col-1));
                if(tempNode.right!=null)q.add(new Pair(tempNode.right,temp.col+1));
            }
        }
        for(Map.Entry<Integer,Integer> e : hm.entrySet())  arr.add(e.getValue());
        return arr;
    }
    class Pair{
        Node n;
        int col;
        Pair(Node n, int col){
            this.n = n;
            this.col = col;
        }
    }
}
