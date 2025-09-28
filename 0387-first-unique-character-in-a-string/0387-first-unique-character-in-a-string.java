class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++){
            char ch =  s.charAt(i);
            int count = 0;
            for (int j = 0; j < n;j ++){
                  if (s.charAt(j) == ch) count++;
                  if (count > 1) break;
            }
            if (count == 1) return i;
        }

        return -1;

    }
}