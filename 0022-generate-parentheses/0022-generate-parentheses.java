class Solution {

    
     private void helper(int n, ArrayList<String> ans, StringBuilder sb, int open, int close){
     
        if (open > n || close > n) return;
            if (open == n && close == n){
                ans.add(sb.toString());
                return;
            }

            // add open bracket:
            sb.append('(');
            helper(n, ans, sb, open+1, close);
            


            // add close bracket:
            if (open != close){
            sb.deleteCharAt(sb.length()-1);
            sb.append(')');
            helper(n, ans, sb, open, close+1);
            }
           if (sb.length() > 1) sb.deleteCharAt(sb.length()-1);
     }

    public List<String> generateParenthesis(int n) {
         ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, ans, sb, 0,0);
         return ans;
    }
}