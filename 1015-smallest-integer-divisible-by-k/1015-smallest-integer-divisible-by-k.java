class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        if (k == 1) return 1;
        // long n = 1;
        // StringBuilder sb = new StringBuilder('1');
        // while(n % k != 0){
        //      sb.append('1');
        //      n = Long.parseLong(sb.toString());
        // }

        // return sb.length();

        int rem = 0;
        for (int i = 1; i <= k; i++){
            rem = (rem*10 + 1) % k;

            if (rem == 0) return i;

        }

        return -1;


    }
}