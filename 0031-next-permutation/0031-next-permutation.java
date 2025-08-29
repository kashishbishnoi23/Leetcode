class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // start from back -> find the point where the array is not in descending order anymore:
       int i = n-1;
       while(i > 0 && nums[i] <= nums[i-1]){
          i--;
       } 

       if (i == 0){
          // reverse the array and return:
          int start = 0;
          int end = n-1;
          while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
          }
          return;
       }

       int replacement = -1;

       int temp = nums[i-1];
       for (int l = n-1; l >= i; l--){
           if (nums[l] > temp){
            replacement = l;
            break;
           }
       }

       nums[i-1] = nums[replacement];
       nums[replacement] = temp;

       // ab i se n-1 ko ascending order me arrange krdo:
       int [] temparr = new int [n-i];
    //    if (temparr.length <= 1) return;
       int indx = 0;
       for (int j = i; j < n; j++){
        temparr[indx++] = nums[j];
       }

       Arrays.sort(temparr);
       indx = 0;
       for (int j = i; j < n; j++){
        nums[j] = temparr[indx++];
       }

   
    }
}