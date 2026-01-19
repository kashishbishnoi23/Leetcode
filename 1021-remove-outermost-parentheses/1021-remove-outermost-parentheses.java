class Solution {
    public String removeOuterParentheses(String s) {
        int balance = 0;
        StringBuilder res = new StringBuilder();

        // if its open -> increase the balance, if its a close bracket -> decrease the balance

        for (char ch : s.toCharArray()){
            if (ch == '('){
                
                if (balance > 0){
                    res.append(ch); // append only if its not an outer (
                }

                balance++;


            } else {

                balance--;
                if (balance > 0){
                    res.append(ch);
                }

            }
        }

        return res.toString();
    }
}