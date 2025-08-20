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

    // private int helper(TreeNode root, int[] maxi){
    //     if (root == null) return 0;

    //     int left = helper(root.left, maxi);

    //     int right = helper(root.right, maxi);  
    //     maxi[0] = Math.max(maxi[0], left+right);

    //     return 1 + Math.max(left, right);

    // }

    private int helper(TreeNode root, int [] maxi){
        if (root == null) return 0;
        
        int left = helper(root.left, maxi);
        int right = helper(root.right, maxi);

        maxi[0] = Math.max(left + right, maxi[0]);

        return 1 + Math.max(left, right);


    }
    public int diameterOfBinaryTree(TreeNode root) {
        // int[] maxi = {0};

        // helper(root, maxi);

        // return maxi[0];

        int [] maxi = {0};
        helper(root, maxi);

        return maxi[0];


    }
}