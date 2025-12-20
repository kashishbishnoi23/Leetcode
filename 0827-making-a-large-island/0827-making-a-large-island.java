class Solution {

    class DSU{
        int N;
        int [] parent;
        int[] size;
        public DSU(int n){
           this.N = n;
           this.parent = new int[n];
           this.size = new int [n];

           for (int i = 0; i < n; i++) parent[i] = i;

           for (int i = 0; i < n; i++){
            size[i] = 1;
           }
        }

        public void union(int node1, int node2){
            int par1 = findPar(node1);
            int par2 = findPar(node2);

            if (par1 == par2) return; // already connected:

            if (size[par1] >= size[par2]){
               parent[par2] = par1;
               size[par1] += size[par2]; 
            } else {
                parent[par1] = par2;
                size[par2] += size[par1];
            }

        }

        public int findPar(int node){
            if (parent[node] == node) return node;

            return parent[node] = findPar(parent[node]);
        }

        public int getSize(int node){
            int par = findPar(node);
            return size[par];
        }

    }


    public int largestIsland(int[][] grid) {
        int n = grid.length;

        // kitne number of nodes honge -> n*n
        int nodes = n*n;

        DSU dsu = new DSU(nodes);

        // pehle nodes ko connect krke islands banao and have their sizes 
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0},{0, -1}};
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    for (int[] dir : dirs){
                        int newrow = i + dir[0];
                        int newcol = j + dir[1];

                        if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < n && grid[newrow][newcol] == 1){
                            // union krdo:
                            int node1 = i*n + j;
                            int node2 = newrow*n + newcol;
                            dsu.union(node1, node2);
                        }
                    }
                }
            }
        }

        int ans = 0;

        // now go to each 0 -> go to its neighbours -> create new big islands

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int newsize = 1;
                HashSet<Integer> st = new HashSet<>();
                if (grid[i][j] == 0){
                    for (int[] dir : dirs){
                        int newrow = i + dir[0];
                        int newcol = j + dir[1];

                        if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < n && grid[newrow][newcol] == 1){
                            int node = newrow*n + newcol;
                            int masterNode = dsu.findPar(node);
                                   
                            if (!st.contains(masterNode)){
                                st.add(masterNode);
                                newsize += dsu.getSize(masterNode);
                            }

                        }
                    }
                }

                ans = Math.max(ans, newsize);

            }
        }

        for (int i = 0; i < nodes; i++){
            ans = Math.max(ans, dsu.size[i]);
        }

        return ans;

    }
}