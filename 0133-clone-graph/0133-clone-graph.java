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

        Map<Integer, ArrayList<Integer>> hashing = new TreeMap<>();

        // go to neighbours of node:

        Queue<Node> q = new LinkedList<>();

        ArrayList<Node> arraylist = new ArrayList<>(101);

        for (int i = 0; i <= 100; i++){
            arraylist.add(new Node(i));
        }

        q.add(node);

        while(!q.isEmpty()){
            Node nod = q.poll();
            int val = nod.val;

            hashing.put(val, new ArrayList<>());
            for (Node neigh : nod.neighbors){
                hashing.get(val).add(neigh.val);

                if (!hashing.containsKey(neigh.val)){
                    q.add(neigh);
                }
            }
        }

        for (int nod : hashing.keySet()){
            Node nodee = arraylist.get(nod);

            List<Node> neighbours = new ArrayList<>();

            for (int neigh : hashing.get(nod)){
                neighbours.add(arraylist.get(neigh));
            }
            nodee.neighbors = neighbours;
            
        }

        return arraylist.get(1);






        
    }
}