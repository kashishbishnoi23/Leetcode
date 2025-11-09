class Solution {
    private void dfs(int node, boolean[] visited, int[][] isConnected){
         
         visited[node] = true;

        // go to the neighbours:
        for (int i = 0; i < isConnected.length; i++){
            if (isConnected[node][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i, visited, isConnected);
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++){
            // mark the current node as visited:
            if (!visited[i]){
            visited[i] = true;
            dfs(i, visited, isConnected);
            count ++;
            }
        }

        return count;

    }
}