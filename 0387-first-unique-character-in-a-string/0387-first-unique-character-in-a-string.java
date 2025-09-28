class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();

        // for (int i = 0; i < n; i++){
        //     char ch =  s.charAt(i);
        //     int count = 0;
        //     for (int j = 0; j < n;j ++){
        //           if (s.charAt(j) == ch) count++;
        //           if (count > 1) break;
        //     }
        //     if (count == 1) return i;
        // }

        Map<Character, ArrayList<Integer>> hashing = new LinkedHashMap<>();
        for (int i = 0; i < n; i++){
            char key = s.charAt(i);
            if (!hashing.containsKey(s.charAt(i))){
                hashing.put(key, new ArrayList<>());               
                hashing.get(key).add(i);
                hashing.get(key).add(1);
                continue;
            }
            int count = hashing.get(key).get(1);
            hashing.get(key).add(1, count+1);
        }

        for (char key : hashing.keySet()){
            System.out.println(key);
            if (hashing.get(key).get(1) == 1) return hashing.get(key).get(0); 
        }

        

        return -1;

    }
}