/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
               Node front = q.poll();
               Node left = front.left;
               Node right = front.right;
            //    Node next = front.next;

               if (i <= size-2){
                front.next = q.peek();
               }

               if (left != null){
                  q.offer(left);
               }

               if (right != null){
                   q.offer(right);
                }

            }
        }

        return root;
    }
}