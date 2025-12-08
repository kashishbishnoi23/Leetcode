class Solution {
    public int countOdds(int low, int high) {

        if (low == high){
            if (low % 2 == 0){
                return 0;
            } else {
                return 1;
            }
        }
        int between = high-low-1;

        if (low % 2 != 0 && high % 2 != 0){
            return between/2 + 2;
        } else if (low % 2 == 0 && high % 2 == 0){
            return between/2 + 1; 
        } else {
            return between/2 + 1;
        }
    }
}