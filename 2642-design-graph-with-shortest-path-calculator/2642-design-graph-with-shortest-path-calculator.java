class Graph {
    
    Integer[][] dis;
    int n;
    public Graph(int n, int[][] edges) {
        dis = new Integer[n][n];
        this.n = n;

        for (int i = 0; i < n; i++){
            Arrays.fill(dis[i], null);
            dis[i][i] = 0;
        }

    

        for (int [] edge : edges){
            int a = edge[0];
            int b = edge[1];
            int w = edge[2];

            dis[a][b] = w;

        }
        
        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (dis[i][k] != null && dis[k][j] != null){
                        if (dis[i][j] == null || dis[i][j] > dis[i][k] + dis[k][j]){
                        dis[i][j] = dis[i][k] + dis[k][j];
                        } 
                    }
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {

        int a = edge[0];
        int b = edge[1];
        int w = edge[2];

        dis[a][b] = w;
        dis[a][a] = 0;
        dis[b][b] = 0;

        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (dis[i][k] != null && dis[k][j] != null ){

                        if (dis[i][j] == null || dis[i][j] > dis[i][k] + dis[k][j]){
                        dis[i][j] = dis[i][k] + dis[k][j];
                        }
                    }
                }
            }
        }


        
        
    }
    
    public int shortestPath(int node1, int node2) {
        
        if (dis[node1][node2] != null){
            return dis[node1][node2];
        }

        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */