class Solution {

    class Pair{
        int node;
        int dist;
         
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
        
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        
        HashMap<Integer, Set<Pair>> hashing = new HashMap<>();
        for (int [] time : times){
            int first = time[0];
            int second = time[1];
            int distance = time[2];

            if (!hashing.containsKey(first)){
                hashing.put(first, new HashSet<>());
            }

            hashing.get(first).add(new Pair(second, distance));
        }

        int[] distance = new int[n+1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

        pq.offer(new Pair(k, 0));
        distance[k] = 0;

        while(!pq.isEmpty()){
            Pair front = pq.poll();
            int node = front.node;
            int curr_dist = front.dist;

            // if (distance[node] >= curr_dist){
            //     distance[node] = curr_dist;
            // } else {
            //     continue;
            // }
             
            if (!hashing.containsKey(node)) continue;
            // go to its neighbours:
            for (Pair neighbour : hashing.get(node)){
                int neighnode = neighbour.node;
                int distance_ = neighbour.dist;

                int new_dist = curr_dist + distance_;

                if (distance[neighnode] > new_dist){
                    distance[neighnode] = new_dist;
                    pq.offer(new Pair(neighnode, new_dist));
                } 
            }
        }


       int ans = -1;

    //    for (int dist : distance){
    //     if (dist == Integer.MAX_VALUE){
    //         return -1;
    //     }
    //     if (dist != 0 ){
    //         ans = Math.max(ans, dist);
    //     }
    
    //    }

    for (int i = 1; i <= n; i++){
        if (distance[i] == Integer.MAX_VALUE) return -1;
        if (distance[i] != 0) ans = Math.max(ans, distance[i]);
    }

       return ans;





    }
}