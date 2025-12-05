class Solution {

    public int collectTheCoins(int[] coins, int[][] edges) {
       int n = coins.length;
        List<List<Integer>> adj = new ArrayList<>();
        int[] deg = new int[n];

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // build graph
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            deg[u]++;
            deg[v]++;
        }

        // Phase 1 pruning : remove leaf nodes without coins
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (deg[i] == 1 && coins[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            if (deg[u] == 0) continue;

            deg[u] = 0; // removed

            for (int v : adj.get(u)) {
                if (deg[v] > 0) {
                    deg[v]--;
                    if (deg[v] == 1 && coins[v] == 0) {
                        q.offer(v);
                    }
                }
            }
        }

        // Phase 2 pruning : two rounds (distance ≤ 2)
        for (int round = 0; round < 2; round++) {

            for (int i = 0; i < n; i++) {
                if (deg[i] == 1) {
                    q.offer(i);
                }
            }

            while (!q.isEmpty()) {
                int u = q.poll();
                if (deg[u] == 0) continue;

                deg[u] = 0;

                for (int v : adj.get(u)) {
                    if (deg[v] > 0) {
                        deg[v]--;
                    }
                }
            }
        }

        // count remaining edges
        int cnt = 0;
        for (int[] e : edges) {
            if (deg[e[0]] > 0 && deg[e[1]] > 0) {
                cnt++;
            }
        }

        return cnt * 2;

    
    }
}