class Solution {

    static class DSU{
        int N;
        int[] parent;
        int [] size;
        public DSU(){
            this.N = 26;
            this.parent = new int[N];
            this.size = new int[N];

            for (int i = 0; i < N; i++){
                parent[i] = i;
            }

            for (int i = 0; i < N; i++){
                size[i] = 0;
            }
        }

        public boolean union(int node1, int node2){
            int par1 = findPar(node1);
            int par2 = findPar(node2);

            if (par1 == par2) return false;

            if (size[par1] >= size[par2]){
                parent[par2] = par1;
            } else {
                parent[par1] = par2;
            }

            return true;

        }

        public int findPar(int node){
            if (parent[node] == node) return node;

            return parent[node] = findPar(parent[node]);
        }

        
    }
    public boolean equationsPossible(String[] equations) {

        int n = equations.length;
        DSU dsu = new DSU();

        for (int i = 0; i < n; i++){
            String e = equations[i];
            char first = e.charAt(0);
            char second = e.charAt(3);

            int indx1 = first - 'a';
            int indx2 = second - 'a';

            if (e.charAt(1) == '='){
              dsu.union(indx1, indx2);
            }

        }

        for (int i = 0; i < n; i++){
            String e = equations[i];
            char first = e.charAt(0);
            char second = e.charAt(3);

            int indx1 = first - 'a';
            int indx2 = second - 'a';
            if (e.charAt(1) == '!'){
                // if (!dsu.union(indx1, indx2)) return false;
                int par1 = dsu.findPar(indx1);
                int par2 = dsu.findPar(indx2);
                if (par1 == par2) return false;
            }

        }



        return true;
        
    }
}