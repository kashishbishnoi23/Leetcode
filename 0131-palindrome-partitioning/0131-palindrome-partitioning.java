class Solution {

    private void recursive(List<List<String>> ans, List<String> path, int indx, String s){ 
          
        if (indx == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = indx; i < s.length(); i++){
            // is index pe partition possible hai??
            String str = s.substring(indx, i+1);
            if (isPalindrome(str)){
                // agar palindrome hai ise path me add kro
                path.add(str);
                // aage badho
                recursive(ans, path, i+1, s);
                path.remove(path.size()-1);
            }
        }
    }


    private boolean isPalindrome(String s){
        if (s.length() == 1) return true;

        int start = 0;
        int end = s.length()-1;

        while(start < end){
            if (s.charAt(start) != s.charAt(end)) return false;
            start ++;
            end --;
        }
        return true;

    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        recursive(ans, path, 0, s);
        return ans;
    }
}