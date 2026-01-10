class Solution {

    private double pow(double x, int n){

        if (n == 0 ) return 1;
        if (n == 1) return x;

        double half = pow(x, n/2);

        if (n % 2 == 0){
            return half*half;
        } else {
            return x*half*half;
        }

        
    }
    public double myPow(double x, int n) {
        
        double ans = pow(x, n);

        if (n > 0){
            return ans;
        } else {
            return 1/ans;
        }

    }
}