/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    public Node copyRandomList(Node head) {

        // beta key to unique nahi hai but index to unique hoga na to map me vo daal

        // node kis index pe pada hai
        HashMap<Node, Integer> hashing = new HashMap<>(); 
        HashMap<Integer, Node> hashing2 = new HashMap<>();

        Node temp = head;
        int indx = 0;

        while(temp != null){
            Node node = new Node(temp.val);
            hashing.put(temp, indx);
            hashing2.put(indx, node);
            temp = temp.next;
            indx ++;
        }

        Node newhead = hashing2.get(0);
        temp = head;
        Node temp2 = newhead;
        indx = 0;

        while(temp != null){
            temp2.next = hashing2.getOrDefault(indx+1, null);
            // int random = (temp.random == null) ? -1 : hashing.getOrDefault(random, null);
            int random = hashing.getOrDefault(temp.random, -1);
            temp2.random = hashing2.getOrDefault(random, null);
            temp = temp.next;
            temp2 = temp2.next;
            indx++;
        }


        return newhead;
        
    }
}