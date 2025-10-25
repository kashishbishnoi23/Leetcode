class Solution {

    private int recursive(String s, int index, int n ){

        if (index == n) return index;

        // if open bracket -> check kro ki aage close bracket ha ya nahi:
        char ch = s.charAt(index);

        if (ch == '(' || ch == '[' || ch == '{'){
            char closing = (ch == '(') ? ')' : (ch == '[' ? ']' : '}');
            int closeIndex = recursive(s, index+1, n);

            if (closeIndex == -1 || closeIndex == n || s.charAt(closeIndex) != closing) return -1;

            return recursive(s, closeIndex+1, n);
            


        }
            
        return index;
        

       

    }
    public boolean isValid(String s) {
        // Stack<Character> st = new Stack<>();

        // for(int i = 0; i < s.length(); i++){
        //     // if it is an open bracket, push it :
        //     char ch = s.charAt(i);
        //     if (ch == '(' || ch == '[' || ch == '{'){
        //         st.push(ch);
        //     } else {
        //         if (st.isEmpty()) return false;

        //         if (ch == ')' && st.peek() == '(' ||  ch == ']' && st.peek() == '[' || ch == '}' && st.peek() == '{'){
        //             st.pop();
        //         } else {
        //             return false;
        //         }
        //     }
        // }

        // return st.isEmpty();

        return recursive(s, 0, s.length()) == s.length() ? true :false;
    }
}