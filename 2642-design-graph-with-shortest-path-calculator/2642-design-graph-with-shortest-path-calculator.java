class Graph {
    List<int[]>[] adj;

    public Graph(int n, int[][] edges) {
        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
        }
    }

    public void addEdge(int[] edge) {
        adj[edge[0]].add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int start, int end) {
        int n = adj.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];

            if (u == end) return d;
            if (d > dist[u]) continue;

            for (int[] nxt : adj[u]) {
                int v = nxt[0];
                int w = nxt[1];
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        return -1;
    }
}



// class Graph {
    
//     Integer[][] dis;
//     int n;
//     public Graph(int n, int[][] edges) {
//         dis = new Integer[n][n];
//         this.n = n;

//         for (int i = 0; i < n; i++){
//             Arrays.fill(dis[i], null);
//             dis[i][i] = 0;
//         }

    

//         for (int [] edge : edges){
//             int a = edge[0];
//             int b = edge[1];
//             int w = edge[2];

//             dis[a][b] = w;

//         }

//         // my k is b and i = a 

        
//         for (int k = 0; k < n; k++){
//             for (int i = 0; i < n; i++){
//                 for (int j = 0; j < n; j++){
//                     if (dis[i][k] != null && dis[k][j] != null){
//                         if (dis[i][j] == null || dis[i][j] > dis[i][k] + dis[k][j]){
//                         dis[i][j] = dis[i][k] + dis[k][j];
//                         } 
//                     }
//                 }
//             }
//         }
//     }
    
//     public void addEdge(int[] edge) {

//         int a = edge[0];
//         int b = edge[1];
//         int w = edge[2];

//         dis[a][b] = w;

        
//         for (int i = 0; i < n; i++){
//             for (int j = 0; j < n; j++){
//                 if (dis[i][a] != null && dis[b][j] != null){
//                     int newdis = dis[i][a] + w + dis[b][j];
//                     if (dis[i][j] == null || dis[i][j] > newdis){
//                         dis[i][j] = newdis;
//                     }
//                 }
//             }
//         }

//         // for (int k = 0; k < n; k++){
//         //     for (int i = 0; i < n; i++){
//         //         for (int j = 0; j < n; j++){
//         //             if (dis[i][k] != null && dis[k][j] != null ){

//         //                 if (dis[i][j] == null || dis[i][j] > dis[i][k] + dis[k][j]){
//         //                 dis[i][j] = dis[i][k] + dis[k][j];
//         //                 }
//         //             }
//         //         }
//         //     }
//         // }


        
        
//     }
    
//     public int shortestPath(int node1, int node2) {
        
//         if (dis[node1][node2] != null){
//             return dis[node1][node2];
//         }

//         return -1;
//     }
// }

// /**
//  * Your Graph object will be instantiated and called as such:
//  * Graph obj = new Graph(n, edges);
//  * obj.addEdge(edge);
//  * int param_2 = obj.shortestPath(node1,node2);
//  */