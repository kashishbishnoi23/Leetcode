class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<String> st = new HashSet<>();
        

        HashMap<Character, ArrayList<Integer>> hashing = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            if (!hashing.containsKey(s.charAt(i))){
                hashing.put(s.charAt(i), new ArrayList<>());
            }
            hashing.get(s.charAt(i)).add(i);
        }
        


        for (char key : hashing.keySet()){
            ArrayList<Integer> indexes = hashing.get(key);
            if (indexes.size() >= 3){
                StringBuilder temp = new StringBuilder();
                temp.append(key);
                temp.append(key);
                temp.append(key);
                st.add(new String(temp));
            }

            for (int i = 0; i < indexes.size()-1; i++){
                int first = indexes.get(i);
                int next = indexes.get(i+1);
                if (next >= s.length()) break;

                for (int j = first+1; j < next; j++){
                    StringBuilder temp = new StringBuilder();
                    temp.append(s.charAt(first));
                    temp.append(s.charAt(j));
                    temp.append(s.charAt(next));
                    st.add(new String(temp));
                }
            }
        }
     



        return st.size();
    }
}