class Solution {

    static class DSU{
        int N;
        int[] parent;
        int[] size;

        public DSU(int n){
            this.N = n;
            this.parent = new int[n];
            this.size = new int[n];

            for (int i = 0; i < n; i++) parent[i] = i;

            for (int i = 0; i < n; i++){
                size[i] = 1;
            }

        }

        public int findPar(int node){
            if (parent[node] == node) return node;

            return parent[node] = findPar(parent[node]);
        }

        public void union(int node1, int node2){
             
             // if already connected, return:
            int par1 = findPar(node1);
            int par2 = findPar(node2);

            if (par1 == par2) return;

            if (size[par1] >= size[par2]){
                parent[par2] = par1;
                size[par1] += size[par2];
            }else {
                parent[par1] = par2;
                size[par2] += size[par1];
            }
        }
    }

    public int removeStones(int[][] stones) {
       

       // pehle to maxRow aur maxCol kitne ho skte hain vo find kro:
       int maxRow = 0;
       int maxCol = 0;

       int n = stones.length;

       for (int i = 0; i < n; i++){
           maxRow = Math.max(maxRow, stones[i][0]);
           maxCol = Math.max(maxCol, stones[i][1]);
       }

       DSU dsu = new DSU(maxRow + maxCol + 2);

       HashMap<Integer, Integer> hashing = new HashMap<>();

       for (int i = 0; i < n; i++){
        int rowNode = stones[i][0];
        int colNode = maxRow + stones[i][1] + 1;

        dsu.union(rowNode, colNode);

        hashing.put(rowNode, 1);
        hashing.put(colNode, 1);
        
       }

       int cnt = 0;

       for (int key : hashing.keySet()){
           if (dsu.findPar(key) == key){
            cnt ++;
           }
       }

       return n-cnt;


       


        



        // for (int i = 0; i < n; i++){
        //     int row = stones[i][0];
        //     int col = stones[i][1];

        //     // Node node = new Node(row, col);
        //     int node = row*
            
        //     if (!rowhash.containsKey(row)){
        //         rowhash.put(row, new HashSet<>());
        //     }

        //     if (!colhash.containsKey(col)){
        //         colhash.put(col, new HashSet<>());
        //     }
        // }
    }
}