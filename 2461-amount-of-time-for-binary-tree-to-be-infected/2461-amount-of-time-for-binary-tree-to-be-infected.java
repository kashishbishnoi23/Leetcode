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

    private TreeNode inorder(TreeNode node, HashMap<TreeNode, TreeNode> hashing, TreeNode prev, int start){
        if (node == null) return null;
        // if (node.val == start) startNode = node;

        hashing.put(node, prev);
        TreeNode left = inorder(node.left, hashing, node, start);
        TreeNode right = inorder(node.right, hashing, node, start);
        if (node.val == start) return node;

        if (left != null) return left;

        return right;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> hashing = new HashMap<>();
        TreeNode startNode = null;

        startNode = inorder(root, hashing, null, start);

        // start with the start:

        // level order traversal:
        Queue<TreeNode> q  = new LinkedList<>();
        System.out.println(startNode.val);
        q.offer(startNode);
        int t = 0;

        boolean [] visited = new boolean [100001];

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode front = q.poll();
                int val = front.val;
                visited[val] = true;
                TreeNode left = front.left;
                TreeNode right = front.right;
                TreeNode parent = hashing.get(front);

                if (left != null && visited[left.val] == false){
                    q.offer(left);
                }
                if (right != null && visited[right.val] == false){
                    q.offer(right);
                }

                if (parent != null && visited[parent.val] == false) {
                    q.offer(parent);
                }

            }

            if (q.isEmpty()) return t;

            t++;
        }

        return t;




    }
}