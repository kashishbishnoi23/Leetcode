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

        // List<Boolean> ans = new ArrayList<>();
        // if (prerequisites.length == 0){
        //     for (int i = 0; i < queries.length; i++){
        //         ans.add(false);
        //     }
        //     return ans;
        // }

        // int n = numCourses;

        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // for (int i = 0; i < numCourses; i++){
        //     adj.add(new ArrayList<>());
        // }

        // for (int[] p : prerequisites){
        //     adj.get(p[0]).add(p[1]);
        // }

        // boolean[][] isReachable = new boolean[numCourses][numCourses];

        // for (int i = 0; i < numCourses; i++){
        //     dfs(i, i, adj, isReachable);
        // }



        // for (int i = 0; i < queries.length; i++){
        //     int a = queries[i][0];
        //     int b = queries[i][1];

        //     if (isReachable[a][b] == true){
        //         ans.add(true);
        //     } else {
        //         ans.add(false);
        //     }
        // }

        // return ans;

        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // for(int i = 0; i < numCourses; i++){
        //     adj.add(new ArrayList<>());
        // }

        // boolean[][]isReachable = new boolean[numCourses][numCourses];

        // for (int i = 0; i < numCourses; i++){
        //     isReachable[i][i] = true;
        // }

        // for(int[] pre : prerequisites){
        //     int a = pre[0];
        //     int b = pre[1];

        //     adj.get(a).add(b);
        //     isReachable[a][b] = true;
        // }

        // for (int k = 0; k < numCourses; k++){
        //     for (int i = 0; i < numCourses; i++){
        //         for (int j = 0; j < numCourses; j++){
        //             if (isReachable[i][j] == false){
        //                 if (isReachable[i][k] && isReachable[k][j]){
        //                     isReachable[i][j] = true;
        //                 }
        //             }
        //         }
        //     }
        // }

        // ArrayList<Boolean> ans = new ArrayList<>();

        // for (int[] q : queries){
        //     if (isReachable[q[0]][q[1]]){
        //         ans.add(true);
        //     } else {
        //         ans.add(false);
        //     }
        // }

        // return ans;


        // hame query me kuch bhi puchh skte hain ki is it possible to reach this B node from this A node, to hame har node ki reachability har dusre node se nikalni hai -> multi-source problem -> yahan ham floyd warshall algo ka use krte hain -> T.C is O(N^3) -> we try to go through every node from A node to B node
     

     boolean[][] isReachable = new boolean[numCourses][numCourses];

     for (int i = 0; i < numCourses; i++){
        isReachable[i][i] = true;
     }

     for (int[] pre : prerequisites){
        isReachable[pre[0]][pre[1]] = true;
     }

     for (int k = 0; k < numCourses; k++){
        // go through k:
        for (int i = 0; i < numCourses; i++){
            for (int j = 0; j < numCourses; j++){
                // agar mai i se k aa skti hu aur k se j ja skti hu to mai i se j bhi ja skti hu (through k)
                if (isReachable[i][k] && isReachable[k][j]){
                    isReachable[i][j] = true;
                }
            }
        }
     }

     List<Boolean> ans = new ArrayList<>();

     for (int[] q : queries){
         int a = q[0];
         int b = q[1];

         if (isReachable[a][b]){
            ans.add(true);
         } else {
            ans.add(false);
         }
     }

     return ans;
        


    }
}