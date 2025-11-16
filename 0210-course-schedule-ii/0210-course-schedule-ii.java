class Solution {

    private boolean dfs(int curr, Stack<Integer> st, HashMap<Integer, Set<Integer>> hashing, boolean[] visited, boolean[] pathVisited){

        visited[curr] = true;
        pathVisited[curr] = true;

        if (hashing.containsKey(curr)){
        for (int neighbour : hashing.get(curr)){
            if (visited[neighbour] && pathVisited[neighbour]) return false;
            if (!visited[neighbour]){
            visited[neighbour] = true;
            pathVisited[neighbour] = true;
            if (dfs(neighbour, st, hashing, visited, pathVisited) == false) return false;
            }
        }
    }

        st.push(curr);
        pathVisited[curr] = false;

        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create adjacency list:
        boolean[]visited = new boolean[numCourses];
        boolean[]pathVisited = new boolean[numCourses];

        HashMap<Integer, Set<Integer>> hashing = new HashMap<>();

        for (int [] arr : prerequisites){
            int first = arr[1];
            int second = arr[0];
            if (!hashing.containsKey(first)){
                hashing.put(first, new HashSet<>());
            }

            hashing.get(first).add(second);
        }

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < numCourses; i++){
            if (!visited[i]){
                visited[i] = true;
                if (dfs(i, st, hashing, visited, pathVisited) == false) return new int[]{};
            }
        }

        int[] ans = new int[numCourses];
        int index = 0;

        while(!st.isEmpty()){
            ans[index++] = st.pop();
        }

        return ans;
    }
}