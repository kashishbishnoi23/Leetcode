class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int rowstart = 0;
        int rowend = n-1;
        int colstart = 0;
        int colend = m-1;

        while(rowstart <= rowend && colstart <= colend){
            int mid = matrix[rowend][colstart];
            if (mid == target) return true;

            if (mid > target){
                rowend--;
            } else {
                colstart++;
            }
        }

        return false;
    }
}