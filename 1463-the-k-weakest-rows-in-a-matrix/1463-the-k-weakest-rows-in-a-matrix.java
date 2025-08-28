class Solution {
    class Pair{
        int soldiers;
        int index;

        public Pair(int soldiers, int index){
            this.soldiers = soldiers;
            this.index = index;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->{
            if (a.soldiers != b.soldiers){
                return Integer.compare(a.soldiers, b.soldiers);
            }

            return Integer.compare(a.index, b.index);
        });

        for (int i = 0; i < n; i++){
            int count = 0;
            for (int j = 0; j < m; j++){
               if (mat[i][j] == 1){
                count ++;
               } else {
                break;
               }
            }

            pq.offer(new Pair(count, i));
        }
        int [] ans = new int [k];
        int indx = 0;

        while(k-- > 0){
            Pair p = pq.poll();
            ans[indx++] = p.index;
        }

        return ans;


    }
}