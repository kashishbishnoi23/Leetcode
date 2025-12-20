class Solution {


//    static class DSU{
//        int N;
//        int [] parent;

//        public DSU(int n){
//           this.N = n;
//           this.parent = new int[n];

//           for (int i = 0; i < n; i++){
//             parent[i] = i;
//           }
//        }

//        private int findParent(int node){
//           if (parent[node] == node) return node;
//           int masterNode = findParent(parent[node]);
//           parent[node] = masterNode;
//           return masterNode;
//        }

//        private boolean union(int p, int c){
          
//           int parent1 = findParent(p);
//           int parent2 = findParent(c);

//           if (parent1 == parent2) return false;

//           parent[c] = p;

//           return true;


//        }


//    }


private static int find(int a, int[] par){
    if (par[a] == a) return a;

    return par[a] = find(par[a], par);

}
    


    public int[] findRedundantDirectedConnection(int[][] edges) {
       int[] candidate_a = new int[2];
       int[] candidate_b = new int[2];
       int n = edges.length;


       int[] par = new int[n+1];


       for (int[] edge : edges){
        int p = edge[0];
        int c = edge[1];

        if (par[c] != 0){
            // already has a parent:
            candidate_b = edge;
            candidate_a = new int[] {par[c], c};
        } else {
            par[c] = p;
        }
       }

       for (int i = 1; i <= n; i++) par[i] = i;

       for (int[] edge : edges){
        if (edge == candidate_b) continue;

        int a = find(edge[0], par);
        int b = find(edge[1], par);

        if (a == b){
           if (candidate_a[0] != 0 && candidate_a[1] != 0){
            return candidate_a;
           } else {
            return edge;
           }
             
        } else {
            par[a] = b;
        }
       }

       return candidate_b;




    }
}