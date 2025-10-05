class Solution {

    private void recursive(List<String> ans, StringBuilder sb, int n, int open, int close){
        if (close == n){
            ans.add(new String(sb));
            return;
        }

        // add open:
        if (open < n){
            sb.append('(');
            recursive(ans, sb, n, open+1, close);
            sb.deleteCharAt(sb.length()-1);
        }

        // add close
        if (open > close){
            sb.append(')');
            recursive(ans, sb, n, open, close+1);
            sb.deleteCharAt(sb.length()-1);
        }
        


    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        recursive(ans, sb, n, 0, 0);
        return ans;
    }
}