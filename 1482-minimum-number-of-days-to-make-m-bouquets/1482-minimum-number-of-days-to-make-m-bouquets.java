class Solution {

    private boolean isValid(int[] bloomDay, int days, int m, int k){
        int d = 0;

        int i = 0;
        int n = bloomDay.length;
        int b = 0;
        System.out.println("mid = " + days);
        while(i < n){
            int count = 0;
            if (bloomDay[i] > days){
                i++;
                continue;
            }
            while(i < n && count < k && bloomDay[i] <= days){
            // System.out.println(count + " " + b + " " + i);
 
               count++;
               i++;


            }

            if (count >= k){
                b++;
            }
 
        
        }

        if (b >= m) return true;
        return false;
        

    }
    public int minDays(int[] bloomDay, int m, int k) {
        // min 1 din lagega => ho skta hai sab ek hi din me bloom ho jayein and I can use all of them

        int n = bloomDay.length;
        if (n < m) return -1; // number of flowers < number of req bouquet
       
        int start = 1;
        int end = 0;

        for (int day : bloomDay){
            end = Math.max(end, day);
        }

        int ans = -1;

        while(start <= end){
            int mid = start + (end- start)/2;

            // can this be my ans? 
            if (isValid(bloomDay, mid, m, k)){
                ans = mid;
                end = mid-1;
            } else {
                start = mid + 1;
            }
            System.out.println(mid + " " + ans);
        }

        return ans;

    }
}