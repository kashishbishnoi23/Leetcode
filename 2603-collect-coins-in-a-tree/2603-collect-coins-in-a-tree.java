class Solution {

    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        int[] degree = new int[n];

        for (int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
            degree[a]++;
            degree[b]++;

        }

        // vo leaves kaat do jinpe coin nahi hai -> cuz ye leaves hamare kisi kaam ki nahi hai
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++){
            if (degree[i] == 1 && coins[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int front = q.poll();
            // if (degree[front] == 0) continue; 
            degree[front] = 0; // dead leaf

            for (int neigh : adj.get(front)){
                degree[neigh]--;
                if (coins[neigh] == 0 && degree[neigh] == 1){
                    q.offer(neigh);
                }
            }
        }

        // ab meri sari leaves pe sirf coins hai 
         
        for (int rounds = 0; rounds < 2; rounds++){
            for (int i = 0; i < n; i++){
                if (degree[i] == 1){
                    q.offer(i);
                }
            }

            while(!q.isEmpty()){
                int front = q.poll();
                degree[front] = 0;

                for (int neigh : adj.get(front)){
                    if (degree[neigh] > 0) degree[neigh]--;
                }
            }
        }

        int count = 0;

        for (int[] edge : edges){
            int a = edge[0];
            int b = edge[1];

            if (degree[a] > 0 && degree[b] > 0) count++;
        }

        return 2*count;
    
    }
}