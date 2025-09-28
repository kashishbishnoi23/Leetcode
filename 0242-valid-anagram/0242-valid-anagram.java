class Solution {
    public boolean isAnagram(String s, String t) {
        char [] charsArray1 = s.toCharArray();
        Arrays.sort(charsArray1);
        char [] charsArray2 = t.toCharArray();
        Arrays.sort(charsArray2);

        String a = new String(charsArray1);
        String b = new String(charsArray2);

        return a.equals(b);


    }
}