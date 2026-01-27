class Solution {

    static class Pair{
        int node;
        int weight;

        public Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    };

    public int minCost(int n, int[][] edges) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            int w = edge[2];

            adjList.get(a).add(new Pair(b, w));
            adjList.get(b).add(new Pair(a, 2*w));
            
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.offer(new Pair(0,0));

        distance[0] = 0;


        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node; 
            int weight = p.weight;

            // System.out.println(a + " " + b + " "  + cost);
 

            for (Pair neighbours : adjList.get(node)){
                 int neigh = neighbours.node; 
                 int w = neighbours.weight;
                 if (distance[neigh] > w + distance[node]){
                    distance[neigh] = w + distance[node];
                    pq.offer(new Pair(neigh, w + distance[node]));
                 }
            } 
        }

        return distance[n-1] == Integer.MAX_VALUE ? -1 : distance[n-1];


    }
}
