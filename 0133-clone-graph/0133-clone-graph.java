/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) return null;
            Queue<Node> queue = new LinkedList<>();
            HashMap<Integer, Node> hashing = new HashMap<>();
            queue.offer(node);
            hashing.put(node.val, new Node(node.val));
            HashSet<Integer> st = new HashSet<>();

            while(!queue.isEmpty()){
                Node front = queue.poll();
                int nodeVal = front.val;
                List<Node> neighbours = front.neighbors;
                if (st.contains(nodeVal)) continue;
                st.add(nodeVal);

                for (Node nei : neighbours){
                    // create new node if it does'nt exist
                     Node neighbour;
                     if (!hashing.containsKey(nei.val)){
                        neighbour = new Node(nei.val);
                        hashing.put(nei.val, neighbour);
                     } else {
                        neighbour = hashing.get(nei.val);
                     }

                     hashing.get(nodeVal).neighbors.add(neighbour);
                     queue.offer(nei);
                }
            }

            return hashing.get(node.val);



    }
}