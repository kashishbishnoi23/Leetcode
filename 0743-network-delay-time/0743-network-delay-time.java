class Solution {

    class Pair{
        int node;
        int w;

        public Pair(int node, int w){
            this.node = node;
            this.w = w;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for (int [] t : times){
            int a = t[0];
            int b = t[1];
            int w = t[2];

            adj.get(a).add(new Pair(b, w));
        }

        int[] distances = new int[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(k, 0));

        while(!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++){
                Pair front = q.poll();
                int node = front.node;
                int dis = front.w;

                for (Pair neigh : adj.get(node)){
                    if (distances[neigh.node] > dis + neigh.w){
                        distances[neigh.node] = dis + neigh.w;
                        q.offer(new Pair(neigh.node, distances[neigh.node]));
                    }
                }

            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++){
            if (distances[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, distances[i]);
            // System.out.println(distances[i]);
        }

        return ans;
        
    }
}