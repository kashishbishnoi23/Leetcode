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
    public List<Integer> rightSideView(TreeNode root) {
        // List<Integer> lst = new ArrayList<>();

        // if (root == null){
        //     return lst;
        // }

        // Queue<TreeNode> q = new LinkedList<>();

        // q.add(root);

        // while(!q.isEmpty()){
        //     int size = q.size();

        //     for (int i = 0; i < size; i++){
        //         TreeNode node = q.poll();

        //         if (i == size-1){
        //             lst.add(node.val);
        //         }

        //         if (node.left != null){
        //             q.add(node.left);
        //         }

        //         if (node.right != null){
        //             q.add(node.right);
        //         }
        //     }
        // }

        // return lst;
      
    

      ArrayList<Integer> list = new ArrayList<>();
      if (root == null) return list;

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      Map<Integer, Integer> hashing = new TreeMap<>();
      int level = 0;
      while(!queue.isEmpty()){
        int size = queue.size();

        for (int i = 0; i < size; i++){
             TreeNode node = queue.poll();
             hashing.put(level, node.val);

             if (node.left != null){
                queue.add(node.left);
             }

             if (node.right != null){
                queue.add(node.right);
             }
        }

        level++;
      }

      for (int key : hashing.keySet()){
          list.add(hashing.get(key));
      }

      return list;

    





    }
}