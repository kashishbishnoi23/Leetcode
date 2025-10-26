class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        if (k == num.length()) return "0";

        for (int i = 0; i < num.length(); i++){
            char n = num.charAt(i);

            if (st.isEmpty()){
                st.push(n);
            } else {

                while(k > 0 && !st.isEmpty() && st.peek() > n){
                    st.pop();
                    k--;
                }
                st.push(n);
            }

        }

        while(k > 0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        sb.reverse();

        String str = new String(sb);
        int index = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != '0'){
                index = i;
                break;
            }
        }

        boolean allzero = true;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != '0'){
                allzero = false;
                break;
            }
        }

        if (allzero){
            return "0";
        }


        return str.substring(index);




    }
}