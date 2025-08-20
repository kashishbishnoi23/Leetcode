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
    // private int helper(TreeNode root, int[] maxsum){
    //     if (root == null)  return 0;

    //     int left = helper(root.left, maxsum);
    //     int right = helper(root.right, maxsum);

    //     maxsum[0] = Math.max(maxsum[0], Math.max(root.val, Math.max(root.val+left+right, Math.max(root.val + left, root.val+right))));

    //     return Math.max(root.val , Math.max(root.val + left, root.val+right));
    // }



    private int helper(TreeNode root, int[] maxi){
        // if (root.left == null && root.right == null) return root.val;
        if (root == null) return Integer.MIN_VALUE;

        int left = helper(root.left, maxi);
        int right = helper(root.right, maxi);
         
        int newmax = 0;
        int sum = root.val;
        int leftSum = root.val;
        int rightSum = root.val;
        if (root.left != null){
            sum += left;
            leftSum += left;
        }
        if (root.right != null){
            sum += right;
            rightSum += right;
        }



        newmax = Math.max(Math.max(root.val, Math.max(left, right)), sum);
        if (left == Integer.MIN_VALUE) left = 0;
        if (right == Integer.MIN_VALUE) right = 0;
        newmax = Math.max(newmax, Math.max(root.val+left, root.val+right));

        maxi[0] = Math.max(maxi[0], newmax);

        return Math.max(root.val, Math.max(leftSum, rightSum));

    }

    public int maxPathSum(TreeNode root) {
        // if (root.left == null && root.right == null) return root.val;
        // int [] maxi = {root.val};

        // helper(root, maxi);

        // return maxi[0];

        if (root.left == null && root.right == null) return root.val;



        int [] maxi = {Integer.MIN_VALUE};
        helper(root, maxi);
        return maxi[0];
    }
}