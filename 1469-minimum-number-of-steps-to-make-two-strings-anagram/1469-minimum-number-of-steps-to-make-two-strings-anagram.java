class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> hashing1 = new HashMap<>();

        HashMap<Character, Integer> hashing2 = new HashMap<>();

        for (char ch : s.toCharArray()){
            hashing1.merge(ch, 1, Integer::sum);
        }

        for (char ch : t.toCharArray()){
            hashing2.merge(ch, 1,Integer::sum);
        }

        int ans = 0;
        Set<Character> st = new HashSet<>();

        for (char ch : s.toCharArray()){
            if (st.contains(ch)) continue;
            int req_count = hashing1.get(ch);
            int present_count = hashing2.getOrDefault(ch, 0);
            
            st.add(ch);
            if (req_count <= present_count) continue;
            System.out.println(ch + " " + req_count + " " + present_count);
            ans += req_count-present_count;
        }

        return ans;
    }
}