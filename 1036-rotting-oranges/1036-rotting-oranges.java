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
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
    //    int n = grid.length;
    //    int m = grid[0].length;

    //    // push the rotten oranges:

    //    Queue<Pair> q = new LinkedList<>();

    //    for (int i = 0; i < n; i++){
    //     for (int j = 0; j < m; j++){
    //         if (grid[i][j] == 2){
    //             q.add(new Pair(i, j, 0));
    //         }
    //     }
    //    }

    //    int [][] directions = {{0,-1}, {-1, 0}, {1,0}, {0,1}};
    //    int [][] visited = new int [n][m];
    //    int ans = 0;

    //    while(!q.isEmpty()){
    //      int size = q.size();
    //      Pair front = q.poll();
    //      int row = front.row;
    //      int col = front.col;
    //      int distance = front.distance;
    //      ans = Math.max(ans, distance);

    //      for (int[] direction : directions){
    //         int nrow = row + direction[0];
    //         int ncol = col + direction[1];

    //         if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
    //             if (visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
    //                 visited[nrow][ncol] = 1;
    //                 q.add(new Pair(nrow, ncol, distance+1));
    //             }
    //         }


    //      }




         
    //    }

    //    for (int i = 0; i < n; i++){
    //     for (int j = 0; j < m; j++){
    //         if (visited[i][j] == 0 && grid[i][j] == 1){
    //             return -1;
    //         }
    //     }
    //    }

    //    return ans;

    int m = grid.length;
    int n = grid[0].length;
    boolean allEmptyOrRotten = true;
    // if there's no rotten orange and all are fresh then -1
    // if all are empty or already rotten then return 0
    for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){
            if (grid[i][j] == 1){
                allEmptyOrRotten = false;
                break;
            }
        }
    }

    if (allEmptyOrRotten){
        return 0;
    }





    Queue<Pair> queue = new LinkedList<>();

    // push all the rotten oranges to queue -> they all are the starting points 

    for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){
            if (grid[i][j] == 2){
                queue.offer(new Pair(i, j));
            }
        }
    }
    
    int currTime = 0;

    // int [][] visited = new int [m][n];

    int [][] directions = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    while(!queue.isEmpty()){
       int size = queue.size();

       for (int i = 0; i < size; i++){
           // pop the current rotten orange, and push its neighbours in the queue-> cuz now they will get rotten:

           Pair pair = queue.poll();
           int row = pair.row;
           int col = pair.col;

           // go to all four directions:
           for (int [] direction : directions){
              int newrow = row + direction[0];
              int newcol = col + direction[1];

              if (newrow >= 0 && newrow < m && newcol >= 0 && newcol < n && grid[newrow][newcol] == 1){
                // valid neighbour:
                // visited[newrow][newcol] = 1;
                grid[newrow][newcol] = 2;

                queue.offer(new Pair(newrow, newcol));

              }
           }
       }
       currTime ++;
    }

    for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){
            if (grid[i][j] == 1){
                return -1;
            }
        }
    }

    return currTime-1;
     





    }
}