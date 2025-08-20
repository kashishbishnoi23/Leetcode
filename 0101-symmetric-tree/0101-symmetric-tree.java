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

    private boolean helper(TreeNode left, TreeNode right){

        if (left == null && right == null) return true;

        if (left == null && right != null || right == null && left != null || left.val != right.val){
            return false;
        }

        return helper(left.left, right.right) && helper(left.right,right.left);




    }


    private boolean helper2(TreeNode p, TreeNode q){
        if (p == null && q == null) return true;
        if (p == null && q != null || q == null && p != null || p.val != q.val) return false;

        return helper2(p.left, q.right) && helper2(p.right, q.left);




    }
    public boolean isSymmetric(TreeNode root) {
        
        // return helper(root.left, root.right);

        return helper2(root.left, root.right);
    }
}