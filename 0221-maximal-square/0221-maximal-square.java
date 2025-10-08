class Solution {

    private int LargestRectangle(int[] heights){
       int max = 0;
       int n = heights.length;
       Stack<Integer> st = new Stack<>();

       for (int i = 0; i <= n; i++){
          int currHeight = (i == n) ? 0 : heights[i];

          while(!st.isEmpty() && currHeight < heights[st.peek()]){
              int height = heights[st.pop()];
              int width = st.isEmpty() ? i : i-st.peek()-1;

              int area = (height < width) ? height*height : width*width;
              max = Math.max(area, max);
          }

          st.push(i);
       }

       return max;
    }
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int [][] array = new int [n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (i == 0){
                    array[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '1'){
                        array[i][j] = array[i-1][j] + 1;
                    }
                }
            }
        }

        int maxSquare = 0;

        for (int i = 0; i < n; i++){
            maxSquare = Math.max(maxSquare, LargestRectangle(array[i]));
        }

        return maxSquare;


    }
}