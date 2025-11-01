class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];

        // how many letters are same:
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < first.length(); i++){
            char ch = first.charAt(i);
            if (ch == last.charAt(i)){
                sb.append(ch);
            } else {
                break;
            }
        }

        return sb.toString();
    }
}