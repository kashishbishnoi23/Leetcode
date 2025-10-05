class Solution {

    private void dfs(int row, int col, boolean[][] ocean, int[][] heights){
        int n = heights.length;
        int m = heights[0].length;
        if (ocean[row][col] == true) return;

        ocean[row][col] = true;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        for (int [] direction : directions){
            int newrow = row + direction[0];
            int newcol = col + direction[1];

            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m &&  heights[newrow][newcol] >= heights[row][col] && ocean[newrow][newcol] == false){
             dfs(newrow, newcol, ocean, heights);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;


        // check different different for each pacific and atlantic:

        boolean[][] pacific = new boolean [n][m];
        for (int j = 0; j < m; j++){
            dfs(0, j, pacific, heights);
        }
        for (int i = 0; i < n; i++){
            dfs(i, 0, pacific, heights);
        }

        boolean [][] atlantic = new boolean [n][m];

        for (int i = 0; i < n; i++){
            dfs(i, m-1, atlantic, heights);
        }

        for (int j = 0; j < m; j++){
            dfs(n-1, j, atlantic, heights);
        }

        List<List<Integer>>list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (pacific[i][j] && atlantic[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);

                }
            }
        }

        return list;







      

    }
}