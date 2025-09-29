class Solution {

        private int helper(String s, int index, int n) {
        if (index == n) return index; // reached end successfully

        char c = s.charAt(index);

        // If it's an opening bracket, expect the matching closing one later
        if (c == '(' || c == '{' || c == '[') {
            char closing = (c == '(') ? ')' : (c == '{' ? '}' : ']');
            int next = helper(s, index + 1, n); // process inside this pair

            if (next == -1 || next == n || s.charAt(next) != closing) return -1;

            // continue after the closing
            return helper(s, next + 1, n);
        }

        // If it's a closing bracket without matching open → return index (stop recursion)
        return index;
    }

    public boolean isValid(String s) {
    // String replaced = s.replace("()", "")
    //                    .replace("{}", "")
    //                    .replace("[]", "");
    // if (replaced.equals(s)) return s.isEmpty(); // no change

    // return isValid(replaced);

     return helper(s, 0, s.length()) == s.length();
    }

}