class Solution {
    public int characterReplacement(String s, int k) {
        int length = s.length();
        int ans = 1;
        int maxFreq = 0;
        HashMap<Character, Integer> hashing = new HashMap<>();
        int left = 0;

        for (int right = 0; right < length; right++){
            char ch = s.charAt(right);
            maxFreq = Math.max(maxFreq, hashing.merge(ch, 1, Integer::sum));

            while(right-left+1 - maxFreq > k){
                hashing.merge(s.charAt(left), -1, Integer::sum);
                left++;
            }

            ans = Math.max(ans, right-left+1);


        }

        return ans;

        
    }
}