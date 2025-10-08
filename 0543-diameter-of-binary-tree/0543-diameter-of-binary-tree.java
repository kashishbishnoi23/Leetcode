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
    private int helper(TreeNode root, int[] max){
        if (root == null) return 0;

        int left = helper(root.left, max);
        int right = helper(root.right, max);

        max[0] = Math.max(max[0], left+right);

        return 1 + Math.max(left, right);


    }
    public int diameterOfBinaryTree(TreeNode root) {
        int [] max = {0};
        helper(root,  max);

        return max[0];
    }
}