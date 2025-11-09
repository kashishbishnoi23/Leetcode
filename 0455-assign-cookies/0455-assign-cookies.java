class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;

        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        while(i < n && j < m){
            if (g[i] <= s[j]){
                ans ++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return ans;

        
    }
}