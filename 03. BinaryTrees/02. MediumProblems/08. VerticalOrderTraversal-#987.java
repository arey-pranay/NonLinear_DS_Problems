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
        // Initialize a list to store node information (node and its vertical level)
        List<Info> l = new ArrayList<>();

        // Create an Info object for the root node at level 0
        Info i0 = new Info(root, 0);
        
        // Use a queue for level-order traversal (BFS)
        Queue<Info> q = new LinkedList<>();
        q.add(i0);

        // Perform BFS to traverse the tree
        while(!q.isEmpty()) {
            int sz = q.size(); // Get the current level size
            List<Info> chhotiList = new ArrayList<>(); // Temporary list for sorting within the level

            // Process all nodes at the current level
            for(int i = 0; i < sz; i++) {
                Info iN = q.remove(); // Remove node from queue
                chhotiList.add(iN); // Add node to temporary list

                // Add left child to queue with level decreased by 1
                if(iN.node.left != null) {
                    q.add(new Info(iN.node.left, iN.level - 1));
                }
                // Add right child to queue with level increased by 1
                if(iN.node.right != null) {
                    q.add(new Info(iN.node.right, iN.level + 1));
                }
            }

            // Sort nodes at the current level based on value (to maintain order)
            Collections.sort(chhotiList, new chhotiListComparator());

            // Add sorted nodes to the main list
            for(Info i : chhotiList) l.add(i);
        }

        // Sort all nodes based on their vertical level
        Collections.sort(l);

        // Prepare the final result list
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(l.get(0).node.val); // Start with the first node

        // Group nodes with the same vertical level
        for(int i = 1; i < l.size(); i++) {
            if(l.get(i).level != l.get(i - 1).level) {
                ret.add(temp); // Add completed group to result
                temp = new ArrayList<>(); // Start a new group
            }
            temp.add(l.get(i).node.val); // Add node to current group
        }
        ret.add(temp); // Add the last group

        return ret; // Return the final grouped vertical order traversal
    }

    // Class to store node and its corresponding vertical level
    class Info implements Comparable<Info> {
        TreeNode node;
        int level;

        Info(TreeNode n, int l) {
            this.node = n;
            this.level = l;
        }

        // Sorting based on vertical level
        @Override
        public int compareTo(Info i1) {
            return this.level - i1.level;
        }
    }

    // Comparator for sorting nodes at the same level based on their value
    class chhotiListComparator implements Comparator<Info> {
        @Override
        public int compare(Info i1, Info i2) {
            return i1.node.val - i2.node.val;
        }
    }
}
