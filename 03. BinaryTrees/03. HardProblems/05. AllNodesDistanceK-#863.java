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
    HashSet<Integer> left = new HashSet<>();
    HashSet<Integer> right = new HashSet<>();
    HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
    int targetDist=-1;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // int targetDist = findTarget(root,target);
        inorder(root,true,root.val,0,target.val);
        left.remove(root.val);
        right.remove(root.val);

        System.out.println(left);
        System.out.println(right);
        System.out.println(hm);

        ArrayList<Integer> ans = new ArrayList<>();

        int distanceNeeded;
        ArrayList<Integer> options = new ArrayList<>();
        //adding same side nodes with distance = k+targetDist

        boolean inLeft;

        if(left.contains(target.val)) inLeft = true;
        else inLeft = false;

        distanceNeeded = k+targetDist;
        options = hm.get(distanceNeeded);
        if(options != null){
             if(inLeft == true){
            for(int i:options){
                if(left.contains(i) && i!=target.val) ans.add(i);
            }
        } else {
            for(int i:options){
                if(right.contains(i) &&  i!=target.val) ans.add(i);
            }
        }
        }
       
        
        //adding other side nodes with distance = k-targetDitance
        distanceNeeded = k-targetDist;
        options = hm.get(distanceNeeded);
        System.out.println(distanceNeeded);
        System.out.println("options: "+ options);
        if(options != null){
        if(inLeft == false){
            for(int i:options){
                if(left.contains(i) &&  i!=target.val) ans.add(i);
            }
        } else {
            for(int i:options){
                if(right.contains(i) &&  i!=target.val) ans.add(i);
            }
        }
        }
        return ans;

        //normalize the distance of the target from the origin to search on the other side
    }

    // public int findTarget(TreeNode root, TreeNode target){

    // }

    public void inorder(TreeNode root, boolean isLeft, int ogVal,int dist, int target){
        if(target==root.val) targetDist = dist;
        if(root.left!=null)inorder(root.left,isLeft,ogVal,dist+1,target);

        if(isLeft==true) left.add(root.val);
        if(root.val == ogVal)isLeft = false;
        if(isLeft==false) right.add(root.val);

        ArrayList<Integer> temp = new ArrayList<>();
        if(hm.containsKey(dist)) temp = hm.get(dist);
        temp.add(root.val);
        hm.put(dist, temp);

        if(root.right!=null)inorder(root.right,isLeft,ogVal,dist+1,target);

        dist--;
        return;
    }

    // given, k = 2;
    // targetDistFromRoot ( x )= 1;

    // on same side, distance = k + x
    // on other side, distance = k - x

    // dist -> node.val[]

    // class Info{
    //     TreeNode node;
    //     int dist;
    //     Info(TreeNode n, int d){
    //         this.node = n;
    //         this.dist = d;
    //     }
    // }

}
