class Solution {

    private boolean recursive(String s, int index, int open, int close){

        if(close > open) return false;
        if (index == s.length()){
            if (close == open) return true;
            return false;
        }

        char ch = s.charAt(index);

        if (ch == '('){
            return recursive(s, index+1, open+1, close);
        } else if (ch == ')'){
            return recursive(s, index+1, open, close+1);
        } else {
            return recursive(s, index+1, open+1, close) || recursive(s, index+1, open, close+1) || recursive(s, index+1, open, close);
        }

    }
    public boolean checkValidString(String s) {
        // return recursive(s, 0, 0, 0);
        int min = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if (ch == '('){
                min ++;
                max ++;
            } else if (ch == ')'){
                min--;
                max--;
            } else {
                min--;
                max++;
            }

            if (min < 0) min = 0;
            if (max == -1) return false;
        }

        return (min == 0);

    }
}