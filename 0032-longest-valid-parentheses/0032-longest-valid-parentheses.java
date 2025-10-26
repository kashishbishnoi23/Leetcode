class Solution {
    public int longestValidParentheses(String s) {

        int n = s.length();

        // brute force -> remove the valid pairs -> keep the invalid pairs and find difference between them -> that's the length of valid pairs

    /*
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < n; i++){
            
            if (s.charAt(i) == ')'){
                if (!st.isEmpty() && st.peek() != -1 && s.charAt(st.peek()) == '('){
                    st.pop();
                    continue;
                }
            } 
                st.push(i);
            
            
        }

        if (st.isEmpty()){
            return n;
        }

        st.push(n);
        int maxLength = 0;


        while(!st.isEmpty()){
            int second = st.pop();
            if (!st.isEmpty()){
            maxLength = Math.max(maxLength, second - st.peek()-1);
            }
             
        }


        return maxLength;

        */


        // optimised solution -> single interation:

        Stack<Integer> st = new Stack<>();
        int maxLength = 0;

        for (int i = 0; i < n; i++){
            if (s.charAt(i) == ')'){
                if (!st.isEmpty() && s.charAt(st.peek()) == '('){
                    st.pop();
                    int newlength = st.isEmpty() ? i+1 : i-st.peek();
                    maxLength = Math.max(maxLength, newlength);
                    continue;
                }
                if (!st.isEmpty())st.pop();
            } 

            st.push(i);
        }

        return maxLength;




        

        
    }
}