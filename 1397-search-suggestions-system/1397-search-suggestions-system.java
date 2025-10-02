class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int n = searchWord.length();
        Arrays.sort(products);
        int m = products.length;
        List<List<String>> ans = new ArrayList<>();




        for (int i = 0; i < n; i++){
            // ans.get(i) = new ArrayList<>();
            ans.add(i, new ArrayList<>());
            char ch = searchWord.charAt(i);
            int j = 0;
            boolean found = false;
            int start = -1;
            String str = searchWord.substring(0, i+1);
            while(j < m){
                if (i == 0){
                     if (products[j].charAt(0) == ch){
                        start = j;
                        break;        
                     }
                } else {
                    if (products[j].startsWith(str)){
                        start = j;
                        break;
                    }
                }
                j++;
            }

            if (start == -1) continue;
            // pick:
            int count = 0;
            while(start < m && products[start].startsWith(str) && count < 3){
                ans.get(i).add(products[start++]);
                count++;
            }

        }

        return ans;
    }
}