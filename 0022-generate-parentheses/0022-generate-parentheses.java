class Solution {
    private void recursive(List<String> ans, StringBuilder sb, int n, int open, int close){

        if (open == close && close == n){
            ans.add(new String(sb));
            return;
        }

        if (close > open) return;
        
        // i can use open, if open < n:
        if (open < n){
            sb.append('(');
            recursive(ans, sb, n, open+1, close);
            sb.deleteCharAt(sb.length()-1);
        }

        sb.append(')');
        recursive(ans, sb, n, open, close+1);
        sb.deleteCharAt(sb.length()-1);

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        recursive(ans, sb, n, 0, 0);
        return ans;
    }
}