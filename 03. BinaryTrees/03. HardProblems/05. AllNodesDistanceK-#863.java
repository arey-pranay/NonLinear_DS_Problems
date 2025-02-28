// class Solution {
//     HashSet<Integer> left = new HashSet<>();
//     HashSet<Integer> right = new HashSet<>();
//     HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
//     int targetDist = -1;

//     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//         ArrayList<Integer> ans = new ArrayList<>();
//         if(k == 0){
//             ans.add(target.val);
//             return ans;
//         }
//         inorder(root, true, root.val, 0, target.val);
//         left.remove(root.val);
//         right.remove(root.val);

//         int distanceNeeded;
//         ArrayList<Integer> options = new ArrayList<>();

//         // Determine which side the target is on (left or right)
//         boolean inLeft = left.contains(target.val);
        
//         // Add nodes on the opposite side with distance = k - targetDist
//         distanceNeeded = k - targetDist;
//         options = hm.get(distanceNeeded);
//         if (options != null) {
//             if (inLeft) {
//                 for (int i : options) {
//                     if (right.contains(i) && i != target.val) {
//                         ans.add(i);
//                     }
//                 }
//             } else {
//                 for (int i : options) {
//                     if (left.contains(i) && i != target.val) {
//                         ans.add(i);
//                     }
//                 }
//             }
//         }

//         // Add nodes on the same side with distance = k + targetDist
//         distanceNeeded = k + targetDist;
//         options = hm.get(distanceNeeded);
//         if (options != null) {
//             if (inLeft) {
//                 for (int i : options) {
//                     if (left.contains(i) && i != target.val) {
//                         ans.add(i);
//                     }
//                 }
//             } else {
//                 for (int i : options) {
//                     if (right.contains(i) && i != target.val) {
//                         ans.add(i);
//                     }
//                 }
//             }
//         }

//         // Add the root if k == targetDist
//         if (k == targetDist) {
//             ans.add(root.val);
//         }

//         return ans;
//     }

//     public void inorder(TreeNode root, boolean isLeft, int ogVal, int dist, int target) {
//         if (target == root.val) {
//             targetDist = dist;
//         }
        
//         if (root.left != null) {
//             inorder(root.left, true, ogVal, dist + 1, target);
//         }

//         if (isLeft) {
//             left.add(root.val);
//         }

//         if (root.val == ogVal) {
//             isLeft = false;
//         }

//         if (!isLeft) {
//             right.add(root.val);
//         }

//         ArrayList<Integer> temp = hm.getOrDefault(dist, new ArrayList<>());
//         temp.add(root.val);
//         hm.put(dist, temp);

//         if (root.right != null) {
//             inorder(root.right, false, ogVal, dist + 1, target);
//         }
//     }
// }
class Solution {
    // List to store the final result of nodes that are at distance k from the target node
    List<Integer> res = new ArrayList<>();

    // The main method that starts the process of finding nodes at distance k
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Call the helper function to recursively find the nodes at distance k
        helper(root, target, k);
        // Return the final result list containing nodes at distance k from the target
        return res;
    }

    // Helper method to find the target node and traverse the tree to compute distances
    int helper(TreeNode root, TreeNode target, int k) {
        // Base case: If the current node is null, return 0 because there's no node to process
        if (root == null) {
            return 0;
        }

        // If the current node is the target node
        if (root == target) {
            // If the target node is found, call findNode to add nodes at distance k from target
            findNode(root, k);
            return 1; // Return 1 to indicate that the target node is found
        }

        // Recursively search in the left and right subtrees of the current node
        int left = helper(root.left, target, k);
        int right = helper(root.right, target, k);

        // If the target node was found in the left subtree
        if (left > 0) {
            // If the distance from the left subtree is equal to k, add the current root node to result
            if (left == k) {
                res.add(root.val);
            }
            // Call findNode to search the right subtree for nodes at distance (k - left - 1) from current node
            findNode(root.right, k - left - 1);
            // Return the distance from the current node to the target, which is (left + 1)
            return left + 1;
        }

        // If the target node was found in the right subtree
        if (right > 0) {
            // If the distance from the right subtree is equal to k, add the current root node to result
            if (right == k) {
                res.add(root.val);
            }
            // Call findNode to search the left subtree for nodes at distance (k - right - 1) from current node
            findNode(root.left, k - right - 1);
            // Return the distance from the current node to the target, which is (right + 1)
            return right + 1;
        }

        // If the target node is not found in either the left or right subtree, return 0
        return 0;
    }

    // Method to find all nodes at a specific distance from a given node
    void findNode(TreeNode root, int distance) {
        // Base case: If the current node is null, stop the recursion
        if (root == null) return;

        // If the distance is 0, this is the node we are looking for
        if (distance == 0) {
            // Add this node's value to the result list
            res.add(root.val);
            return;
        }

        // Recursively search the left and right subtrees for nodes at distance - 1
        findNode(root.left, distance - 1);
        findNode(root.right, distance - 1);
    }
}
