class Solution {

    class Pair{
        int row;
        int col;
        int maxeffort;

        Pair( int maxeffort, int row, int col){
            this.maxeffort = maxeffort;
            this.row = row;
            this.col = col;
            this.maxeffort = maxeffort;
        }
    }

    private static int [][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] efforts = new int [n][m];
        int ans = -1;

        PriorityQueue<Pair>q = new PriorityQueue<>((x, y) -> x.maxeffort - y.maxeffort);

        q.add(new Pair(0,0,0));

        

        for (int i = 0; i < n; i++){
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }

        efforts[0][0] = 0;

        while(!q.isEmpty()){
            Pair pair = q.poll();
            int effort = pair.maxeffort;
            int row = pair.row;
            int col = pair.col;

            // System.out.println(effort + " " + row + " " + col);

            if (row == n-1 && col == m-1) return effort; 

            // go to all the 4 directions:
            for (int[] direction : directions){
                int nrow = row + direction[0];
                int ncol = col + direction[1];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    int neweffort = Math.abs(heights[row][col] - heights[nrow][ncol]);
                    if (efforts[nrow][ncol] > neweffort){
                        efforts[nrow][ncol] = neweffort;
                        q.add(new Pair(Math.max(effort, neweffort), nrow, ncol));
                    }
                }
            }
        }

        return ans;

        

         


    }
}