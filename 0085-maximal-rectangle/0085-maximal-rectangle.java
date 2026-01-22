class Solution {

    private int solve(int[] arr){
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i = 0; i <= n; i++){
            int curr = (i < n) ? arr[i] : 0;

            while(!st.isEmpty() && curr < arr[st.peek()]){
                int height = arr[st.pop()];
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
        int[][]temp = new int[n][m];

        for (int i = 0; i < n; i++){
            
            for (int j = 0; j < m; j++){
                int curr = matrix[i][j] - '0';
                if (i == 0){
                    temp[i][j] = curr;
                } else {
                    temp[i][j] = curr + temp[i-1][j];
                }
            }
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++){
            int[] arr = temp[i];

            int area = solve(arr);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}