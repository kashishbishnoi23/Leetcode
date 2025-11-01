class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Arrays.sort(strs);
        // String first = strs[0];
        // String last = strs[strs.length-1];

        // how many letters are same:
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < first.length(); i++){
        //     char ch = first.charAt(i);
        //     if (ch == last.charAt(i)){
        //         sb.append(ch);
        //     } else {
        //         break;
        //     }
        // }
         
        
        // return sb.toString();

        String prefix = strs[0];
        // maan liya ki pehla string prefix hai:
        for (int i = 0; i < strs.length; i++){

            // jab tak current string prefix se start nahi krta -> keep on decrementing the prefix:
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}