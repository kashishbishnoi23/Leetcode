class Solution {
    public int smallestNumber(int n) {
       // find the max power:
       int power = 0;
       while(n > 1){
         n/= 2;
         power++;
       } 

       return (int)Math.pow(2, power+1)-1;

    }
}