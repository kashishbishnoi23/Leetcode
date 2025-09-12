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
    static long sum = 0;
    private void recursive(TreeNode root, StringBuilder sb){
        if (root == null) return;
        if (root.left == null && root.right == null){
            sb.append(root.val);
            
            long num = sb.isEmpty() ? 0 : Long.valueOf(sb.toString());
            sum += num;
            // System.out.println("num = " + num);
            // System.out.println("sum = " + sum);
            if (!sb.isEmpty())sb.deleteCharAt(sb.length()-1);
            return;
        }

        // go to left,left left until null, if null take the number, sum it up , erase that number and go to right 
        
        sb.append(root.val);

        recursive(root.left, sb);
        

        recursive(root.right, sb);
        if (!sb.isEmpty()) sb.deleteCharAt(sb.length()-1);

    }

    public int sumNumbers(TreeNode root) {
        sum = 0;
        StringBuilder sb = new StringBuilder();
        recursive(root, sb);

        return (int)sum;
    }
}