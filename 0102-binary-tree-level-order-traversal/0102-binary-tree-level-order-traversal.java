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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        // List<List<Integer>> lst = new ArrayList<>();
        // if (root == null){
        //    return lst;
        // }
        
        // Queue<TreeNode> q = new LinkedList<>();

        // q.add(root);
       



        

        // while(!q.isEmpty()){
        //      int size = q.size();
        //      List<Integer> temp = new ArrayList<>();
        //      for (int i = 0; i < size; i++){
        //         TreeNode front = q.poll();

        //         temp.add(front.val);

        //         if (front.left != null){
        //             q.add(front.left);
        //         }

        //         if (front.right != null){
        //             q.add(front.right);
        //         }


        //      }
        //      lst.add(temp);
        // }

        // return lst;
       
       List<List<Integer>> lst = new ArrayList<>();
       if (root == null) return lst;


        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            // iterate the whole level:
            int size = queue.size();

            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);

                if (node.left != null){
                    queue.add(node.left);
                }

                if (node.right != null){
                    queue.add(node.right);
                }
            }

            lst.add(temp);
        }

        return lst;
    }
}