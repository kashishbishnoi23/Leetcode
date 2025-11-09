class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        int n = bills.length;
        for (int i = 0; i < n; i++){
            if (bills[i] == 5){
                fives ++;
            }  else {
                if (fives == 0) return false;
                if (bills[i] == 10){
                    fives --;
                    tens++;
                } else {
                    if (tens > 0 ){
                        tens --;
                        fives --;
                    } else if (fives < 3){
                        return false;
                    } else {
                        fives -= 3;
                    }


                }
            }
        }

        return true;
    }
}