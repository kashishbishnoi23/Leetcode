class Solution {

    private void recursive(String s, int index, HashSet<String> st, int length, StringBuilder temp){
        if (index > s.length() || length > 3) return;

        if (length == 3){
            System.out.println(temp);
            if (temp.charAt(0) == temp.charAt(2)){
                st.add(new String(temp));
            }
            return;
        } 

        if (index == s.length()) return;

        // pick:
        temp.append(s.charAt(index));
        recursive(s, index+1, st, length+1, temp);


        if (temp.length() > 0){
            temp.deleteCharAt(temp.length()-1);
        }

        // not pick:
        recursive(s, index+1, st, length, temp);

    }
    public int countPalindromicSubsequence(String s) {
        HashSet<String> st = new HashSet<>();
        
        // StringBuilder temp = new StringBuilder();

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