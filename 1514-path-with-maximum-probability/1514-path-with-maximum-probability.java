class Solution {

    class Node{
        int node;
        double prob;

        public Node(int node, double prob){
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            int a = edge[0];
            int b = edge[1];
            double prob = succProb[i];

            adj.get(a).add(new Node(b, prob));
            adj.get(b).add(new Node(a, prob));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));

        pq.offer(new Node(start_node, 1));

        double probab[] = new double[n];
        Arrays.fill(probab, 0);
        probab[start_node] = 1;

        while(!pq.isEmpty()){
            Node front = pq.poll();
            int node = front.node;
            double prob = front.prob;

            if (node == end_node) return prob; 

            for (Node neigh : adj.get(node)){
                 int neigh_node = neigh.node;
                 double neigh_prob = neigh.prob;

                 // new prob:
                 double newprob = prob*neigh_prob;

                 if (newprob > probab[neigh_node]){
                    probab[neigh_node] = newprob;
                    pq.offer(new Node(neigh_node, newprob));
                 }
            }
        }

        return probab[end_node];
    }
}