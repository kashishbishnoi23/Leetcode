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


    // 3 possibilities -> value is between low and high , value is less than low, value is greater than high
    private void recursive(TreeNode root, int low, int high, int [] ans){
        if (root == null) return;
        if (root.val >= low && root.val <= high){
            ans[0] += root.val;

            recursive(root.left, low, high, ans);
            recursive(root.right, low, high, ans);
        } else if (root.val < low){
            recursive(root.right, low, high, ans);
        } else {
            recursive(root.left, low, high, ans);
        }
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int ans[] = {0};

        recursive(root, low, high, ans);

        return ans[0];
    }
}