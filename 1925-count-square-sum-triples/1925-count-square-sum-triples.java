class Solution {

    private int possible(int sum){
        int num = sum/2;

        int start = 1;
        int end = num;

        while(start <= end){
            int mid = start + (end-start)/2;

            if (mid*mid == sum) return mid;

            if (mid*mid < sum){
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }

        return -1;
    }
    public int countTriples(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++){
            for (int j = i+1; j <= n; j++){
                int sum = i*i + j*j;
                int root = possible(sum);

                if (root != -1 && root <= n){
                    count++;
                }
            }
        }

        return 2*count;
    }
}