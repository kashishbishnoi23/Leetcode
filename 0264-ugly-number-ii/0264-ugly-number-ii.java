class Solution {

    private boolean uglyNum(int num){
        if (num == 1) return true;
        if (num == 0) return false;

        while(num % 2 == 0){
            num /= 2;
        }

        while(num % 3 == 0){
            num /= 3;
        }

        while(num % 5 == 0){
            num /= 5;
        }

        if (num > 1) return false;
        return true;
    }

    public int nthUglyNumber(int n) {
        int count = 0;
        int num = 1;

        // while(count < n){
        //     boolean check = uglyNum(num);
        //     if (check)count ++;
        //     if (count >= n) break;
        //     num++;
        // }

        List<Integer> uglyNumbers = new ArrayList<>();
        uglyNumbers.add(1);
        int [] primes = {2,3,5};
        int [] indices = {0,0,0};

        for (int i = 1; i < n; i++){
            int [] newNumbers = {
                uglyNumbers.get(indices[0])*2,
                uglyNumbers.get(indices[1])*3,
                uglyNumbers.get(indices[2])*5
            };

            // min number is the next ugly number:
            int min = Math.min(newNumbers[0], Math.min(newNumbers[1], newNumbers[2]));

            uglyNumbers.add(min);

            // increase the index of number who contributed to ugly number formation:
            for (int j = 0; j < 3; j++){
                if (newNumbers[j] == min){
                    indices[j]++;
                }
            }

         
        }

        return uglyNumbers.get(n-1);
        
    }
}