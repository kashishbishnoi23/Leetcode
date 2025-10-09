class Solution {

    private void dfs(int node, boolean [] visited, ArrayList<ArrayList<Integer>> adjList){
        
        // go to the nodes and visit them:
        for (int neighbour : adjList.get(node)){
            if (visited[neighbour] == false){
                visited[neighbour] = true;
                dfs(neighbour, visited, adjList);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        boolean [] visited = new boolean[n+1];

        // creating an adjacency list:
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (isConnected[i][j] == 1){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int comp = 0;

        for (int i = 0; i < n; i++){
            if (visited[i] == false){
                comp++;
                visited[i] = true;
                dfs(i, visited, adjList);
            }
        }

        return comp;





    }
}