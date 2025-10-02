class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> st = new HashMap<>();
        int ans = 0;
        int left = 0;
        int n = s.length();

        for (int right = 0; right < n; right++){
            char ch = s.charAt(right);
            while(st.containsKey(ch) && st.get(ch) == 1){
                st.merge(s.charAt(left), -1, Integer:: sum);
                left++;
            }
            ans = Math.max(ans, right-left+1);
            st.merge(s.charAt(right), 1 , Integer:: sum);
        }

        return ans;
        
    }
}