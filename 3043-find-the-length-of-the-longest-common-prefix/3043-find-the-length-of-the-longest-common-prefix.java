class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> st = new HashSet<>();

        for (int a : arr1){
            // st.add(String.valueOf(a));
            String str = String.valueOf(a);
            for (int j = 0; j < str.length(); j++){
                st.add(str.substring(0, j+1));
            }
        }

        int ans = 0;

        for (int i = 0; i < arr2.length; i++){
            String str = String.valueOf(arr2[i]);
            for(int j = 0; j < str.length(); j++){
                if (st.contains(str.substring(0, j+1))){
                    ans = Math.max(ans, j+1);
                } else {
                    break;
                }
            }
        }

        return ans;
    }
}