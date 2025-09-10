class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        List<String> lst = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            char [] array = strs[i].toCharArray();
            Arrays.sort(array);

            lst.add(new String(array));

        }

        HashMap<String, ArrayList<Integer>> hashing = new HashMap<>();

        for (int i = 0; i < n; i++){
            if (!hashing.containsKey(lst.get(i))){
                hashing.put(lst.get(i), new ArrayList<>());
            }
       
            hashing.get(lst.get(i)).add(i);
        }

        List<List<String>> ans = new ArrayList<>();

        for (String key : hashing.keySet()){
            List<String> temp = new ArrayList<>();
            for (int indx : hashing.get(key)){
                temp.add(strs[indx]);
            }
            ans.add(temp);
        }

        return ans;
    }
}