class Solution {

    private int LargestRectangle(int[] heights){
        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        int max = 0;

        for (int i = 0; i <= n; i++){
            int curr = (i == n) ? 0 : heights[i];

            while(!st.isEmpty() && curr < heights[st.peek()]){
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i-st.peek()-1;
                max = Math.max(max, height*width);
            }

            st.push(i);
        }

        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] heights = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (i == 0){
                    heights[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '1'){
                        heights[i][j] = 1 + heights[i-1][j];
                    }
                }
            }
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                maxArea = Math.max(maxArea, LargestRectangle(heights[i]));
            }
        }

        return maxArea;



    }
}