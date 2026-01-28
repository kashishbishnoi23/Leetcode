class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];

        // Brute force:
        // for (int i = 0; i <= n-k; i++){
        //     int max = Integer.MIN_VALUE;
        //     for (int j = i; j < i+k; j++){
        //        max = Math.max(max, nums[j]);
        //     }

        //     ans[i] = max;
        // }

        // return ans;


        // Optimised : use a deque -> use window of size k -> fir front se elements nikalte jao -> cuz they are not the part of the window anymore 
        
        // ek to ham index store krayenge na ki element so that we know ki vo element window ka part ha ya nahi

        Deque<Integer> dequeue = new LinkedList<>();
        int left = 0;
        int right = 0;
        int indx = 0;

        while(right < n){
            int curr = nums[right];
            // agar ye element apni window me left wale se bada hai -> iska matlab left wala to max ho nahi skta -> usko ham aram se remove kr skte hain -> so iske peeche se jitne bhi chhote elements hain unko nikal do -> they cannot be the answer , agar manlon curr is 3 aur isse pehle hame 2 aur 6 mile the -> 2 ko 6 hata chuka hoga -> ab front me 6 pada hai -> yahi meri current window ka max hai -> jo ek dum front me hoga 

            while(!dequeue.isEmpty() && nums[dequeue.peekLast()] < curr){
                dequeue.pollLast();
            }

            // add the current:
            dequeue.offerLast(right);

            if (right-left+ 1 == k){
                // window complete ho gayi:
                ans[indx++] = nums[dequeue.peekFirst()];

                // invalid numbers nikal do -> left se chhoto se leke left tak ko
                while(!dequeue.isEmpty() && dequeue.peekFirst() <= left){
                    dequeue.pollFirst();
                }
                left++;
            }

            right++;

        }


        

        return ans;

        






    }
}