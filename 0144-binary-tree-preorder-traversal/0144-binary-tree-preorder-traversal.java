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

    // private void recursive(TreeNode root, List<Integer>lst){
    //     if (root == null) return;

    //     lst.add(root.val);

    //     recursive(root.left, lst);

    //     recursive(root.right, lst);
    // }


    private void recursive(TreeNode root, List<Integer> lst){
        if (root == null) return;
        lst.add(root.val);
        recursive(root.left, lst);
        recursive(root.right, lst);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        // List<Integer> lst = new ArrayList<>();
        // // recursive(root, lst);

        // TreeNode temp = root;

        // Stack<TreeNode> st = new Stack<>();

        // while(!st.isEmpty() || temp != null){

        //     // go to left ka end and keep pushing the roots to the lst:
        //     while(temp != null){
        //         st.push(temp);
        //         lst.add(temp.val);
        //         temp = temp.left;
        //     }

        //     temp = st.pop().right;
            
        // }

        List<Integer> lst = new ArrayList<>();

        recursive(root, lst);

        return lst;





        // return lst;
    }
}