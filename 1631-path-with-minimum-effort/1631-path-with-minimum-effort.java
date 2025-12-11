class Solution {

    class Node{
        int row;
        int col;
        int maxe;
        public Node(int row, int col, int maxe){
            this.row = row;
            this.col = col;
            this.maxe = maxe;
        }
    }
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.maxe, b.maxe));


        pq.offer(new Node(0, 0, 0));

        int[][] directions = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] efforts = new int[n][m];

        for (int i = 0; i < n; i++){
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }

        efforts[0][0] = 0;

        while(!pq.isEmpty()){
            Node front = pq.poll();
            int row = front.row;
            int col = front.col;
            int maxe = front.maxe;

            if (row == n-1 && col == m-1) return maxe;

            for(int[] dir : directions){
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    int neweffort = Math.max(maxe, Math.abs(heights[row][col] - heights[nrow][ncol]));

                    if (neweffort < efforts[nrow][ncol]){
                        efforts[nrow][ncol] = neweffort;
                        pq.offer(new Node(nrow, ncol, neweffort));
                    }


                }
            }



        }

        return -1;
    }
}