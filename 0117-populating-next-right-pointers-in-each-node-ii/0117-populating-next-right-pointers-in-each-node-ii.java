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

    private Node getNext(Node node){
         
        while(node != null){
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;

            node = node.next;
        }

        return null;

    }
    public Node connect(Node root) {

        if (root == null) return null;

        if (root.left != null){
            if (root.right != null){
                root.left.next = root.right;
            } else {
                root.left.next = getNext(root.next);
            }
        }

        if (root.right != null){
            root.right.next = getNext(root.next);
        }
       
        connect(root.right);

        connect(root.left);

        return root;
        
    }
}