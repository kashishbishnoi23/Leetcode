class Solution {
    public int[] beautifulArray(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        while(res.size() < n){
           ArrayList<Integer>temp = new ArrayList<>();
           // get odd parts:
           for (int r : res){
            if (2*r-1 <= n) temp.add(2*r -1);
           }

           // get even part:
           for (int r : res){
            if (2*r <= n) temp.add(2*r);
           }

           res = temp;
        }

        int[] ans = new int[n];
        int index = 0;
        for (int r : res){
            ans[index++] = r;
        }

        return ans;
    }
}