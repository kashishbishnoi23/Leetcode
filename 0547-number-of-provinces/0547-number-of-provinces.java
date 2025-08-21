class Solution {

    // private void dfs(int node, int[] visited, int[][] isConnected){
        
    //     // go to its neighbours:

    //     for (int i = 0; i < isConnected.length; i++){
    //         if (visited[i] == 0 && isConnected[node][i] == 1){
    //             visited[i] = 1;
    //             dfs(i, visited, isConnected);
    //         }
    //     }



    // }

    private void dfs(int node, int[] visited, int[][] isConnected){

        // mark the current node as visited:
        int n = isConnected.length;

        for (int j = 0; j < n; j++){
            if (isConnected[node][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(j, visited, isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        
        // int n = isConnected.length;

        // int[] visited = new int [n];
        // int count = 0;
        // for (int i = 0; i < n; i++){
        //     if (visited[i] == 0){
        //         visited[i] = 1;
        //         dfs(i, visited, isConnected);
        //         count ++;
        //     }
            
        // }

        // return count;

        int n = isConnected.length; // total number of nodes
        int [] visited = new int [n];
        int count = 0;
        for (int i = 0; i < n; i++){
            if (visited[i] == 0){
                count ++;
                visited[i] = 1;
                dfs(i, visited, isConnected);
            }
        }

        return count;







    }
}