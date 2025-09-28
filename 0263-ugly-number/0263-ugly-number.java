class Solution {
    public boolean isUgly(int n) {

        if (n <= 0) return false;
        if (n == 1) return true;

        // agar na 2 se divide hora, na 3 se hora, aur na hi 5 se hora to ugly number nahi h:
        if (n % 2 != 0 && n % 3 != 0 && n % 5 != 0) return false;

        int temp = n;

            // is it divisible by 2:
            while(temp % 2 == 0){
                temp /= 2;
            }

            // is it divisible by 3:
            while(temp % 3 == 0){
                temp /= 3;
            }

            while(temp % 5 == 0){
                temp /= 5;
            }

            if (temp > 1) return false;

            return true;


        



        
    }
}