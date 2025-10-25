class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            // if it is an open bracket, push it :
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            } else {
                if (st.isEmpty()) return false;

                if (ch == ')' && st.peek() == '(' ||  ch == ']' && st.peek() == '[' || ch == '}' && st.peek() == '{'){
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}