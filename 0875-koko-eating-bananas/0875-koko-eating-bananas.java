class Solution {

    private boolean isValid(int[] piles, int h, int bananas){

        int hours = 0;

        for(int i = 0; i < piles.length; i++){
            if (bananas >= piles[i]){
                hours ++;
            } else {
                int temp = (int) Math.ceil((double)piles[i]/bananas);
                // System.out.println(temp);
                hours += temp;
            }

            if (hours > h) return false;
        }

        // System.out.println(bananas + " " + hours);


        if (hours > h) return false;
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {

        int start = 1;
        int end = 0;
        int n = piles.length;

        for (int pile : piles){
            end = Math.max(end, pile);
        }

        if (n == h) return end;
        
        int ans = 0;

        while(start <= end){
            int mid = start + (end-start)/2;

            // agar itne bananas khaye to kaam chalega ya nahi:
            if (isValid(piles, h, mid)){
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }


        }

        return ans;



    }
}