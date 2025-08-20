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

    // private int height(TreeNode root){
    //     if (root == null) return 0;

    //     int left = height(root.left);
    //     int right = height(root.right);

    //     return 1 + Math.max(left, right);
    // }

    // private int helper(TreeNode root){
    //     if (root == null) return 0;

    //     int left = helper(root.left);

    //     if (left == -1) return -1;

    //     int right = helper(root.right);

    //     if (right == -1) return -1;

    //     int diff = Math.abs(left-right);


    //     return diff > 1 ? -1 : 1 + Math.max(left, right);
    // }


    // private int findHeight(TreeNode root){
    //     if (root == null) return 0;
    //     int left = findHeight(root.left);
    //     int right = findHeight(root.right);

    //     return 1+ Math.max(left, right);
    // }


    private int helper(TreeNode root){
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1) return -1;

        if (Math.abs(left - right) > 1){
            return -1;
        }
        return 1 + Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {
        // if (root == null) return true;

        // int left = height(root.left);

        // int right = height(root.right);

        // if (Math.abs(right-left) > 1) return false;

        // return isBalanced(root.left) && isBalanced(root.right);

        // if (helper(root) == -1) return false;

        // return true;


         
        //  if (root == null) return true;

        //  int leftHeight = findHeight(root.left);
        //  int rightHeight = findHeight(root.right);

        //  if (Math.abs(leftHeight - rightHeight) > 1){
        //     return false;
        //  }

        //  return (isBalanced(root.left) && isBalanced(root.right));
         
      








    if (helper(root) == -1) return false;
    return true;









    }
}