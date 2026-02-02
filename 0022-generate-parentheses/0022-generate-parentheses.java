class Solution {


    private void recursion(int open, int close, int n, StringBuilder sb, List<String> ans){

        if (open == n && close == n){
            ans.add(new String(sb));
            return;
        }

        // take open:
        if (open < n){
            sb.append('(');
            recursion(open+1, close, n, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }

        // take close:
        if (open > close){
            sb.append(')');
            recursion(open, close+1, n, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }

    }

 
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        recursion(0, 0, n, sb, ans);



        return ans;
    }
}