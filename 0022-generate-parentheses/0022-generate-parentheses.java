class Solution {

    private void recursion(List<String> ans, int open, int close, StringBuilder sb){

        if (open == 0 && close == 0){
            ans.add(new String(sb));
            return;
        }

        // take open:
        if (open > 0){
            sb.append('(');
            recursion(ans, open-1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        // I can add close if open > close:
        if (open < close){
            sb.append(')');
            recursion(ans, open, close-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        recursion(ans, n, n, sb);

        return ans;
    }
}