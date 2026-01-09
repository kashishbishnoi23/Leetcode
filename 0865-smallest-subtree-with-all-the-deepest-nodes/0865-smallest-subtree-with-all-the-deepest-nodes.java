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

    HashMap<TreeNode, Integer> hashing = new HashMap<>();
    int maxDepth = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        dfs(root, null); // current node ki max depth = parent ki max depth + 1

        hashing.put(null, -1);

        // now run dfs again -> if u find a node with max depth or null -> return it -> if left and right of current are not null -> return current -> we've got a subtree

        return ans(root);

        


    }

    private TreeNode ans(TreeNode node){
        if (hashing.get(node) == maxDepth || node == null) return node;

        TreeNode L = ans(node.left);

        TreeNode R = ans(node.right);

        if (L != null && R != null) return node;

        if (L != null) return L;

        if (R != null) return R;

        return null;
    }

    private void dfs(TreeNode node, TreeNode parent){

        if (node != null){
            hashing.put(node, hashing.getOrDefault(parent, -1) + 1);
            maxDepth = Math.max(maxDepth, hashing.get(node));
            dfs(node.left, node);
            dfs(node.right, node);
        }

    }
}