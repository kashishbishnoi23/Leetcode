class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        int n = s.length();
        for (int i = 0; i < n; i++){
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
                if (st.isEmpty()) return false;
                char top = st.peek();
                System.out.println("i = " + i + " hello" );


                if (s.charAt(i) == ')' && top == '(' || s.charAt(i) == '}' && top == '{' || s.charAt(i) == ']' & top == '['){
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.push(s.charAt(i));
            }
        }

        if (!st.isEmpty()) return false;

        return true;
    }
}