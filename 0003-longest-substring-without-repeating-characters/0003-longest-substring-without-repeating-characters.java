class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;

        HashMap<Character, Integer> hashing = new HashMap<>();

        int right = 0;
        int max = 0;

        while(right < n){
            // kya ye character pehle aa chuka hai
            char ch = s.charAt(right);
            if (hashing.containsKey(ch)){
                int last = hashing.get(ch);
                while(left <= last){
                    left++;
                }
            }

            hashing.put(ch, right);
            max = Math.max(max, right-left+1);
            right++;
        }

        return max;
    }
}