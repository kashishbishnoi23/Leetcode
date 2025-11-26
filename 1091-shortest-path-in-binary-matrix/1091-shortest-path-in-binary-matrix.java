class Solution {

    class Node{
        int row; 
        int col;
        int dist;

        public Node(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1) return -1;

        Queue<Node> queue = new LinkedList<>();

        // start from top-left:
        queue.offer(new Node(0, 0, 0));

        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1,-1}, {1, -1}, { -1, 1}, {1, 1}};

        int[][] visited = new int[n][n];

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                Node front = queue.poll();
                int row = front.row;
                int col = front.col;
                int dist = front.dist;

                if (row == n-1 && col == n-1) return dist+1;

                for (int[] d : dir){
                    int newrow = row + d[0];
                    int newcol = col + d[1];

                    if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < n && visited[newrow][newcol] == 0 && grid[newrow][newcol] == 0){
                        visited[newrow][newcol] = 1;
                        queue.offer(new Node(newrow, newcol, dist+1));
                    }
                }
                
            }
        }

        return -1;



    }
}