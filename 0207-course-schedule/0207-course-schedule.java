class Solution {

    private boolean dfs(int node, boolean[] visited, HashMap<Integer, Set<Integer>> hashing, boolean[] pathVisited){
        // mark current node as visited:
        visited[node] = true;
        pathVisited[node] = true;
        
        if (hashing.containsKey(node)){
        for (int neigh : hashing.get(node)){
            if (visited[neigh] && pathVisited[neigh]) return true;
            if (!visited[neigh]){
                visited[neigh] = true;
                pathVisited[neigh] = true;
                if (dfs(neigh, visited, hashing,pathVisited) == true) return true;
            }
        }
    }

    pathVisited[node] = false;

    return false;
       
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // check if cycle exists or not:
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        HashMap<Integer, Set<Integer>> hashing = new HashMap<>();

        for (int[] arr : prerequisites){
            int first = arr[1];
            int second = arr[0];
            
            if (!hashing.containsKey(first)){
                hashing.put(first, new HashSet<>());
            }
            hashing.get(first).add(second);
        }

        for (int i = 0; i < numCourses; i++){
            if (!visited[i]){
            visited[i] = true;
            if (dfs(i, visited, hashing,pathVisited) == true) return false;
            }
        }
        return true;
    }
}