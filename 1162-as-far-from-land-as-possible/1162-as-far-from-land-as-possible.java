class Solution {

    class Node {
        int row;
        int col;
        int val;
        int dist;

        public Node(int row, int col, int val, int dist){
            this.row = row;
            this.col = col;
            this.val = val;
            this.dist = dist;
        }
    }
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Node> queue = new LinkedList<>();
        int[][] distance = new int[n][m];

        // Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1){
                    queue.offer(new Node(i, j, 1, 0));
                }
            }
        }

        int[][] directions = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};

        while(!queue.isEmpty()){
            Node front = queue.poll();
            int row = front.row;
            int col = front.col;
            int dist = front.dist;

            for (int[] dir : directions){
                int newrow = row + dir[0];
                int newcol = col + dir[1];

                if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && (distance[newrow][newcol] == Integer.MAX_VALUE || distance[newrow][newcol] > dist + 1 )){
                  distance[newrow][newcol] = dist + 1;
                  queue.offer(new Node(newrow, newcol, grid[newrow][newcol], dist+1));
                }
            }



        }

        int ans = -1;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 0 && distance[i][j] != Integer.MAX_VALUE){
                    ans = Math.max(ans, distance[i][j]);
                }
            }
        }

        return ans;
        
    }
}