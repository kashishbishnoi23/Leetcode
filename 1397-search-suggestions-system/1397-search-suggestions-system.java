class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int n = searchWord.length();
        Arrays.sort(products);
        int m = products.length;
        List<List<String>> ans = new ArrayList<>();




        for (int i = 0; i < n; i++){
            ans.add(i, new ArrayList<>());
            int j = 0;
            int start = -1;
            String str = searchWord.substring(0, i+1);
            while(j < m){
                if (products[j].startsWith(str)){
                        start = j;
                        break;
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