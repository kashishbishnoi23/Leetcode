class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        
        // left se leke right tak ek window banegi -> isme jis character ki frequency maximum hai + k (bache hue characters jinko ham change krke max frequency wale character me convert kr skte hain) -> agar ye dono milke window size k equal aa jaye -> valid window else its an invalid window
        int maxFreq = 0;
        int ans = 1;
        HashMap<Character, Integer> hashing = new HashMap<>();
        while(right < n){
             char ch = s.charAt(right);
             maxFreq =  Math.max(maxFreq, hashing.merge(ch, 1, Integer:: sum));

             while(maxFreq + k < right-left+1){
                  hashing.merge(s.charAt(left), -1, Integer:: sum);
                  left++;
             }

             ans = Math.max(ans, right-left+1);
             right++;
        }

        return ans;
    }
}