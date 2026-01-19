class Solution {
    public String largestOddNumber(String num) {

        int n = num.length();
        if ((num.charAt(n-1)- '0') % 2 == 1) return num;
        
        // int first = -1;
        int last = -1;
        for (int i = 0; i < num.length(); i++){
            
            int ch = num.charAt(i) - '0';
            if (ch % 2 == 1){
              last = i;

            }
        }

        if (last == -1) return "";

        return num.substring(0, last+1);
    }
}