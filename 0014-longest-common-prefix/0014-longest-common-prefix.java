class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n = strs.length-1;

        // return strs[0].substring(strs[n]);
        StringBuilder sb = new StringBuilder();
        int m = Math.min(strs[0].length(), strs[n].length());
        for(int j = 0; j < m; j++){
            String a = strs[0];
            String b = strs[n];

            if (a.charAt(j) == b.charAt(j)){
                sb.append(a.charAt(j));
            } else {
                break;
            }
        }

        return sb.toString();
    }
}