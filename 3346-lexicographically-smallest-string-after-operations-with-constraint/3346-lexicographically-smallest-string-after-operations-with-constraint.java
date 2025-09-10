class Solution {
    public String getSmallestString(String s, int k) {
        StringBuilder str = new StringBuilder("");
        
        int n = s.length();
        int remaining = k;

        for (int i = 0; i < n; i++){
            if (remaining == 0){
                str.append(s.charAt(i));
                continue;
            }

            // append the closest small character:
            int indx = s.charAt(i) - 96;
            int diff = 0;
            if (indx <= 13){
                diff = indx-1;
            } else {
                diff = 27-indx;
            }
            if (diff <= remaining){
                str.append('a');
            } else {
                // if not forward, then backward:
                int newindx = indx - remaining;
                str.append((char)(newindx+96));
                diff = remaining;
            }
            remaining -= diff;
            // System.out.println(remaining);
        }

        return str.toString();

    }
}