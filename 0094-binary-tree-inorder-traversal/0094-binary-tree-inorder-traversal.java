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

    // private void recursive(TreeNode root, List<Integer> lst){
    //     if (root == null) return;

    //     recursive(root.left, lst);

    //     lst.add(root.val);

    //     recursive(root.right, lst);
    // }
    
    private void recursive(List<Integer> lst, TreeNode root){
        if (root == null) return;

        // go to left:
        recursive(lst, root.left);

        lst.add(root.val);

        // go to right:
        recursive(lst, root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        
        // recursive(root, lst);
        // List<Integer> lst = new ArrayList<>();

        // TreeNode temp = root;
        // Stack<TreeNode> st = new Stack<>();

        // while(!st.isEmpty() || temp != null){
             
        //      while(temp != null){
        //         st.push(temp);
        //         temp = temp.left;
        //      }

        //      // left has become null -> pick out the root

        //     temp = st.pop();
        //     lst.add(temp.val);
        //     temp = temp.right;
        // }

        List<Integer> lst = new ArrayList<>();

        recursive(lst, root);




  



        return lst;
        
    }
}