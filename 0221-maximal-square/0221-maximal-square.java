class Solution {

    private int LargestRectangle(int[] array){
        int n = array.length;
        int maxArea = 0;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++){
            int currHeight = (i == n ? 0 : array[i]);

            while(!st.isEmpty() && array[st.peek()] > currHeight){
                int height = array[st.pop()];
                int width = st.isEmpty() ? i : i-st.peek()-1;
                System.out.println("height = " + height + " width = " + width);
                int area = height < width ? height*height : width*width;
                maxArea = Math.max(maxArea, area);
                
            }
            st.push(i);
        }

        return maxArea;


    }
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] array = new int [n][m];

        for (int j = 0; j < m; j++){
            for (int i = 0; i < n; i++){
                if (matrix[i][j] == '0'){
                    array[i][j] = 0;
                    continue;
                } else {
                    if (i == 0){
                        array[i][j] = 1;
                    } else {
                        array[i][j] = 1 + array[i-1][j];
                    }
                }
            }
        }
        int ans = 0;

        for (int i = 0; i < n; i++){
            ans = Math.max(ans, LargestRectangle(array[i]));
            System.out.println("ans = " + ans);
        }

        return ans;


    }
}