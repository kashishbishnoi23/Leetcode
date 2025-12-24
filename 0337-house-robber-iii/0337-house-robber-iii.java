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

    private int recursion(TreeNode node, boolean prev, HashMap<TreeNode, int[]> hashing){

        if (node == null) return 0;

        int index = (prev == true) ? 1 : 0;

        if (hashing.containsKey(node) && hashing.get(node)[index] != -1) return hashing.get(node)[index];

        int max = 0;
        // Can I pick the node:
        int pick = 0;
        if (prev == false){
            // I want to pick the node:
            pick = node.val + recursion(node.left, true, hashing) + recursion(node.right, true, hashing);
        }



        // or I cannot pick the node or I am choosing to not pick the node
        int notpick = recursion(node.left, false, hashing) + recursion(node.right, false, hashing);

        int ans = Math.max(pick, notpick);
        // hashing.put(node, ans);
        hashing.putIfAbsent(node, new int[]{-1, -1});
        hashing.get(node)[index] = ans;
  
        return ans;

      
    }
    public int rob(TreeNode root) {
      
       HashMap<TreeNode, int[]> hashing = new HashMap<>();
    
       return recursion(root, false, hashing);
    }
}