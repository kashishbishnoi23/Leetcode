class Solution {
    
    private void recursive(List<String> ans, StringBuilder sb, List<String> strs, int indx){
        if (indx == strs.size()){
            ans.add(new String(sb));
            return;
        }
        for (int i = 0; i < strs.get(indx).length(); i++){
            String curr = strs.get(indx);
            sb.append(curr.charAt(i));
            recursive(ans, sb, strs, indx+1);
            sb.deleteCharAt(sb.length()-1);
        }


    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> hashing = new HashMap<>();

        hashing.put('1', "");
        hashing.put('2', "abc");
        hashing.put('3', "def");
        hashing.put('4', "ghi");
        hashing.put('5', "jkl");
        hashing.put('6', "mno");
        hashing.put('7', "pqrs");
        hashing.put('8', "tuv");
        hashing.put('9', "wxyz");

        List<String> strs = new ArrayList<>();

        for (char d : digits.toCharArray()){
            strs.add(hashing.get(d));
        }

        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        recursive(ans, sb, strs, 0);

        return ans;
    }
}