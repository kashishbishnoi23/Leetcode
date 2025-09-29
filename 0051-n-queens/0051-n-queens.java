class Solution {
     
    private boolean isValid(int n, int row, int index, List<StringBuilder> temp){
        if (row == 0) return true;
        // agar upar wali row ka element is row me clash na kre to valid, otherwise not valid:

        boolean above = false;

        for (int i = 0; i < row; i++){
            if (temp.get(i).charAt(index) == 'Q') return false;
        }
        
        int col = 1;
        for (int j = row-1; j >= 0; j--){
            if (index-col >= 0 && temp.get(j).charAt(index-col) == 'Q') return false;

            if (index+ col < n && temp.get(j).charAt(index+col) == 'Q') return false;
            col++;
        }

        return true;      
    }
    private boolean helper(int n, int row, List<List<String>> ans, List<StringBuilder> temp){
        if (row == n){
            // ans.add(temp.toString());
            ArrayList<String> newstr = new ArrayList<>();
            for (StringBuilder sb : temp){
                newstr.add(sb.toString());
            }
            ans.add(newstr);
            return true;
        }

       // pick current index:
       for (int i = 0; i < n; i++){
          if (isValid(n, row, i, temp)){
              // add queen at current index and move on:
              temp.get(row).setCharAt(i, 'Q');

                boolean next = helper(n, row+1, ans, temp);
                // helper(n, row+1, ans, temp);
                temp.get(row).setCharAt(i, '.');
                // if (next == true) return true;
          }
       }
       return false;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<StringBuilder> temp = new ArrayList<>();

        // n number of rows:
        for (int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++){
                sb.append('.');
            }
            temp.add(sb);
        }
        helper(n, 0, ans,temp);

        return ans;
    }
}