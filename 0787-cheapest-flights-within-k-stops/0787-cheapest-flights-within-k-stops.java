class Solution {

    class Pair {
        int node;
        int price;
        int stops;

        public Pair(int node, int price, int stops){
            this.node = node;
            this.price = price;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();

        for (int[] f : flights){
            adj.computeIfAbsent(f[0], x -> new ArrayList<>())
               .add(new Pair(f[1], f[2], 0));
        }

        // pq based on cheapest price
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.price - b.price);

        pq.offer(new Pair(src, 0, 0));

        // cost[node][stops] = best cost till now
        int[][] best = new int[n][k+2];
        for (int i = 0; i < n; i++)
            Arrays.fill(best[i], Integer.MAX_VALUE);

        best[src][0] = 0;

        while (!pq.isEmpty()){

            Pair cur = pq.poll();
            int node = cur.node;
            int price = cur.price;
            int stops = cur.stops;

            // If destination reached:
            if (node == dst) return price;

            // If stops exhausted:
            if (stops == k+1) continue;

            if (!adj.containsKey(node)) continue;

            for (Pair neigh : adj.get(node)){

                int nextNode = neigh.node;
                int newCost = price + neigh.price;

                if (newCost < best[nextNode][stops+1]){
                    best[nextNode][stops+1] = newCost;
                    pq.offer(new Pair(nextNode, newCost, stops+1));
                }
            }
        }

        return -1;
    }
}
