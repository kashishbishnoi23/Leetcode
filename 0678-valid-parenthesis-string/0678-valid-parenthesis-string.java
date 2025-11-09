class Solution {

    // private boolean recursion(String s, int index, int open, int close){
    //     if (close > open) return false;
    //     if (index == s.length()){
    //         if (close == open) return true;
    //         return false;
    //     }
    //     if (s.charAt(index) == '('){
    //         return recursion(s, index+1, open+1, close);
    //     } else if (s.charAt(index) == ')'){
    //         return recursion(s, index+1, open, close+1);
    //     } else {
    //         return recursion(s, index+1, open, close) || recursion(s, index+1, open+1, close) || recursion(s, index+1, open, close+1);
    //     }
    // }
    public boolean checkValidString(String s) {
        // return recursion(s, 0, 0, 0);

        int min = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if (ch == '('){
                min++;
                max++;
            } else if (ch == ')'){
                min--;
                max--;
            } else {
                min--;
                max++;
            }

            if (min < 0) min = 0;
            if (max < 0) return false;
        }

        if (min > 0) return false;
        return true;
    }
}