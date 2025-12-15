class Solution {

    class DSU{

        int N;
        int [] parent;
        int[] size;

        public DSU(int N){
            this.N = N;
            this.parent = new int[N+1];
            this.size = new int[N+1];

            for (int i = 1; i <= N; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int node){
            if (parent[node] == node) return node;

            int masterParent = findParent(parent[node]);

            parent[node] = masterParent;

            return masterParent;

        }

        public boolean union(int node1, int node2){
            int masterParentNode1 = findParent(node1);
            int masterParentNode2 = findParent(node2);

            if (masterParentNode1 == masterParentNode2) return true;

            if (size[masterParentNode1] >= size[masterParentNode2]){
                size[masterParentNode1] += size[masterParentNode2];
                parent[masterParentNode2] = masterParentNode1;
            } else {
                size[masterParentNode2] += size[masterParentNode1];
                parent[masterParentNode1] = masterParentNode2;
            }

            return false;
        }

    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        DSU dsu = new DSU(n);

        int[] ans = new int[2];

        for (int[] edge : edges){
            int a = edge[0];
            int b = edge[1];

            if (dsu.union(a, b)){
                // agar already union ho rkha hai to yahi edge remove krna padega -> else it will create a cycle
                ans[0] = a;
                ans[1] = b;
                return ans;
            }
        }

        return ans;
    }
}