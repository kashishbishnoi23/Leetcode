class Solution {
    public String getSmallestString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        
        int temp = k;
        for (int i = 0; i < s.length(); i++){
            if (temp == 0){
                sb.append(s.charAt(i));
                continue;
            }
            int ascii = s.charAt(i);
            int actual_diff = Math.abs(97-ascii);
            int diff = actual_diff;
            if (actual_diff > 13){
                diff = 26-actual_diff;
            }

            if (diff <= temp){
                sb.append('a');
                temp -= diff;
            }  else {
                char newletter = (char)(ascii-temp);
                sb.append(newletter);
                temp = 0;
            }
        }

        return sb.toString();
    }
}