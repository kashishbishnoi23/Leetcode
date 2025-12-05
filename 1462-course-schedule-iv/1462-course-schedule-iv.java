class Solution {

    private void dfs(int node, int start, ArrayList<ArrayList<Integer>> adj, boolean[][] isReachable){
        if (isReachable[start][node] == true) return;
        isReachable[start][node] = true;
        
        for (int neigh : adj.get(node)){
            dfs(neigh, start, adj, isReachable);
        }
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        // agar ek course A se mai course B pahuch paa rhi hu -> directly ya indirectly -> iska matlab muje B se pehle A course krna padega so B is dependent on A 

        List<Boolean> ans = new ArrayList<>();
        if (prerequisites.length == 0){
            for (int i = 0; i < queries.length; i++){
                ans.add(false);
            }
            return ans;
        }

        int n = numCourses;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites){
            adj.get(p[0]).add(p[1]);
        }

        boolean[][] isReachable = new boolean[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++){
            dfs(i, i, adj, isReachable);
        }



        for (int i = 0; i < queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];

            if (isReachable[a][b] == true){
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;


    }
}