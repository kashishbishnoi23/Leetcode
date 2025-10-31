class Solution {

    private boolean isValid(int total, int k){

        for (int j =  0; j <= total; j++){
            // increment:
            int val = 1;
            val += j;
            int operLeft = total-j;
            
            val = (operLeft+1)*val;

            if (val >= k){
                return true;
            }

        }

        return false;

    }
    public int minOperations(int k) {
        if (k == 1) return 0;
        int ans = k-1;
        
        int start = 1;
        int end = k-1;

        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);

        while(start <= end){
            int mid = start + (end - start)/2;

            if (isValid(mid, k)){
                ans = Math.min(ans, mid);
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return ans;




    }
}