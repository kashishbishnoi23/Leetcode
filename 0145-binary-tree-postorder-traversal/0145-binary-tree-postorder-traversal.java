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
    private void recursive(TreeNode root, List<Integer> lst){
        if (root == null) return;

        recursive(root.left, lst);
        recursive(root.right, lst);

        lst.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {

        
        
        // List<Integer> lst = new ArrayList<>();
        // // recursive(root, lst);

        // Stack<TreeNode> st = new Stack<>();

        // TreeNode curr = root;

        // while(!st.isEmpty() || curr != null){
        //     if (curr != null){
        //         st.push(curr);
        //         curr = curr.left;
        //     } else {
        //         TreeNode temp = st.peek().right;

        //         if (temp == null){
        //             while(!st.isEmpty() && temp == st.peek().right){
        //                 temp = st.pop();
        //                 lst.add(temp.val);
        //             }
        //         } else{
        //             curr = temp;
        //         }
        //     }
        // }
        
        List<Integer> lst = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;
        while(!st.isEmpty() || curr != null){
            // go to left until left is null:
            if (curr != null){
                st.push(curr);
                curr = curr.left;
            } else {
                // if curr is null -> we are at left end , go to the root's right
                TreeNode temp = st.peek().right;

                if (temp == null){
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        lst.add(temp.val);                    }
                } else {
                    curr = temp;
                }
            }

        }




        return lst;
        
    }
}