class Solution {

    // class Pair{
    //     int row;
    //     int col;
    //     int distance;

    //     Pair(int row, int col, int distance){
    //         this.row = row;
    //         this.col = col;
    //         this.distance = distance;
    //     }
    // }


    class Pair{
        int row;
        int col;
        int distance;

        public Pair(int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

    }


    public int[][] updateMatrix(int[][] mat) {
        // int n = mat.length;
        // int m = mat[0].length;
        // int[][] distance = new int [n][m];

        // int [][] visited = new int [n][m];

        // // push the 0s to the queue:

        // Queue<Pair> q = new LinkedList<>();

        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < m; j++){
        //         if (mat[i][j] == 0){
        //             q.add(new Pair(i, j, 0));
        //             visited[i][j] = 1;
        //         }
        //     }
        // }

        // int [][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // while(!q.isEmpty()){
        //     Pair front = q.poll();
        //     int row = front.row;
        //     int col = front.col;
        //     int d = front.distance;
        //     distance[row][col] = d;

        //     // go to its neighbours:

        //     for (int[] direction : directions){
        //         int nrow = row + direction[0];
        //         int ncol = col + direction[1];

        //         if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
        //             if (visited[nrow][ncol] == 0 && mat[nrow][ncol] == 1){
        //                 visited[nrow][ncol] = 1;
        //                 q.add(new Pair(nrow, ncol, d+1));
        //             }
        //         }
        //     }

        // }

        // return distance;








        int rows = mat.length;
        int cols = mat[0].length;

        int [][] visited = new int [rows][cols];
        int [][] distance = new int [rows][cols];

        Queue<Pair> queue = new LinkedList<>();

        // push all the starting points -> zeroes to the queue:

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (mat[i][j] == 0){
                    queue.offer(new Pair(i, j, 0));
                }
            }
        }

        int [][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};


        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                Pair pair = queue.poll();
                int row = pair.row;
                int col = pair.col;
                int dis = pair.distance;
                distance[row][col] = dis;

                // agar neighbour 1 hai to push the node with distance as distance + 1

                for (int [] direction : directions){
                    int newrow = row + direction[0];
                    int newcol = col + direction[1];

                    if (newrow >= 0 && newrow < rows && newcol >= 0 && newcol < cols && mat[newrow][newcol] == 1 && visited[newrow][newcol] == 0){
                    visited[newrow][newcol] = 1;
                    queue.offer(new Pair(newrow, newcol,  dis+1));
                }
            }
        }
    }

    return distance;






    }
    
}