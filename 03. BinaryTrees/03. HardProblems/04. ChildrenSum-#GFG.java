class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        if(func(root)==true) return 1;
        return 0;
    }
    public static boolean func(Node root){
        if(root==null) return true; //if the passed child is null
        if(root.left == null && root.right == null) return true; //because we reached leaf node
        int l=0 ,r=0;
        if(root.left != null) l = root.left.data; 
        if(root.right != null) r = root.right.data; 
        return (l+r== root.data && func(root.left) && func(root.right));
    }
    
    
}
