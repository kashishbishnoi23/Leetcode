class Solution {

    private boolean isValid(int n, int row, int index, List<StringBuilder> temp){
        if (row == 0) return true;

        // check if above columns have Q:
        for (int i = 0; i < row; i++){
            if (temp.get(i).charAt(index) == 'Q') return false;
        }

        int col = 1;
        for (int j = row-1; j >= 0; j--){
            if (index-col >= 0 && temp.get(j).charAt(index-col) == 'Q') return false;

            if (index + col < n && temp.get(j).charAt(index+col) == 'Q') return false;
            col++;
        }

        return true;
    }

    private int helper(int n, int row, List<StringBuilder> temp){

        if (row == n) return 1;
        
        int comb = 0;
        // fill the queen in current row:
        for (int i = 0; i < n; i++){
            // fill the queen at current index if valid:
            if (isValid(n, row, i, temp)){
                temp.get(row).setCharAt(i, 'Q');
                // go to next row:
                comb += helper(n, row+1, temp);

                // reset:
                temp.get(row).setCharAt(i, '.');
            }
        }

        return comb;
        
    }

    public int totalNQueens(int n) {
        
        List<StringBuilder> temp = new ArrayList<>();
        for (int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++){
                sb.append('.');
            }
            temp.add(sb);
        }

        return helper(n, 0, temp);


    }
}