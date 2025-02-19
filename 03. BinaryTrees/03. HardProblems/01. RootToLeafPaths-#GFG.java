// class Solution {
//     public static ArrayList<ArrayList<Integer>> Paths(Node root) {
//         ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
//         if (root == null) {
//             return paths;
//         }
        
//         // Create ArrayList to store current path
//         ArrayList<Integer> currentPath = new ArrayList<>();
        
//         // Call helper method to find all paths
//         findPaths(root, currentPath, paths);
        
//         return paths;
//     }
    
//     private static void findPaths(Node node, ArrayList<Integer> currentPath, 
//                                 ArrayList<ArrayList<Integer>> paths) {
//         if (node == null) {
//             return;
//         }
        
//         // Add current node's data to the path
//         currentPath.add(node.data);
        
//         // If we've reached a leaf node, add the current path to our result
//         if (node.left == null && node.right == null) {
//             paths.add(new ArrayList<>(currentPath));
//         } else {
//             // Recursively explore left and right subtrees
//             // Process left subtree first to maintain required order
//             findPaths(node.left, currentPath, paths);
//             findPaths(node.right, currentPath, paths);
//         }
        
//         // Backtrack by removing the current node from path
//         currentPath.remove(currentPath.size() - 1);
//     }
// }


class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        return func(ans, arr, root);
    }
    public static ArrayList<ArrayList<Integer>> func(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, Node n){
        arr.add(n.data);
        if(n.left!=null)func(ans,arr,n.left);
        if(n.right!=null)func(ans,arr,n.right);
        if(n.left == null && n.right == null){
            // System.out.println(arr);
            // ans.add(arr);
            // System.out.println(ans);
            // System.out.println();
            ans.add(new ArrayList<>(arr)); //kyuki array is pasased by reference isliye aage jb bhi changes hoge tb wo bdi wale array me jo chhoti arrays daali hai, sbme changes hoge
        }
        arr.remove(arr.size()-1);
        return ans;
    }
