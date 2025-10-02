class Solution {

    public int minTaps(int n, int[] ranges) {
         
         int [] arr = new int [n+1];

         for (int i = 0; i <= n; i++){
            if (ranges[i] == 0) continue;

            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            arr[left] = Math.max(arr[left], right);
         }
         
         int max = arr[0];
         int count = 1;
         if (max >= n) return count;

         int taps = 0, end = 0, farthest = 0;
for (int i = 0; i <= n; i++) {
    if (i > farthest) return -1;       // cannot extend
    if (i > end) {
        taps++;
        end = farthest;
    }
    farthest = Math.max(farthest, arr[i]);
}
return taps;

         

     

    }
}