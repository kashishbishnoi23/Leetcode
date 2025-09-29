class Solution {

    public boolean isValid(String s) {
    String replaced = s.replace("()", "")
                       .replace("{}", "")
                       .replace("[]", "");
    if (replaced.equals(s)) return s.isEmpty(); // no change
    return isValid(replaced);
    }
}