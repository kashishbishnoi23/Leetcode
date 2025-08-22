class Solution {
    
    private void reverse(int [] heights){
        int n = heights.length;
        int start = 0;
        int end = n-1;

        while(start < end){
            int temp = heights[start];
            heights[start] = heights[end];
            heights[end] = temp;
            start++;
            end--;
        }
    }
    private int LargestArea(int [] heights){
        int maxi = 0;
        Arrays.sort(heights);
        reverse(heights);
        int n = heights.length;

        for (int i = 0; i < n; i++){
            maxi = Math.max(maxi,  Math.max(heights[i], heights[i]*(i+1)));
        }

        return maxi;
    }
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int [][] temp = new int [n][m];
        Stack<Integer> st = new Stack<>();

        for (int col = 0; col < m; col++){
            for (int row = 0; row < n; row++){
                if (row == 0){
                    temp[row][col] = matrix[row][col];
                    continue;
                }
                if (matrix[row][col] == 1){
                    temp[row][col] = matrix[row][col] + temp[row-1][col];
                } 
            }
        }


        int maxArea = 0;

        for (int i = 0; i < n; i++){
            maxArea = Math.max(maxArea, LargestArea(temp[i]));
        }

        return maxArea;
    }
}