class Solution {

    public void dfs(int[][] image, int row, int col, int color, int startcolor, int[][] visited){
        // mark the current node as visited:
        visited[row][col] = 1;
        int n = image.length;
        int m = image[0].length;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int [] dir : directions){
            int newrow = row + dir[0];
            int newcol = col + dir[1];

            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && visited[newrow][newcol] == 0 && image[newrow][newcol] == startcolor){
                image[newrow][newcol] = color;
                visited[newrow][newcol] = 1;
                dfs(image, newrow, newcol, color, startcolor, visited);
            }
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        // run dfs:
        int[][] visited = new int[n][m];
        int startcolor = image[sr][sc];

        // start with the sr and sc
        image[sr][sc] = color;
        dfs(image, sr, sc, color, startcolor, visited);

        return image;

    }
}