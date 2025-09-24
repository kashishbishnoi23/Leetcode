class Solution {

    private boolean helper(int indx, String s, Stack<Character>st){
        if (indx == s.length()){
            if (st.isEmpty()) return true;
            return false;
        }

        char bracket = s.charAt(indx);

        if (bracket == '[' || bracket == '(' || bracket == '{'){
            st.push(bracket);
        } else {
            if (st.isEmpty()) return false;
            if (bracket == ']' && st.peek() == '[' || bracket == '}' && st.peek() == '{' || bracket == ')' && st.peek() == '('){
                st.pop();
            } else {
                return false;
            }
        }

        return helper(indx+1, s, st);
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        return helper(0, s, st);
    }
}