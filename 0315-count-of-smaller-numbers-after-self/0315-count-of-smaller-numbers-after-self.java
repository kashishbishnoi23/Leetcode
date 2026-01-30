class Solution {

    private void merge(int left, int mid, int right, int[][] arr, int[] count){

        int i = left;
        int j = mid+1;
        int[][] temp = new int[right-left+1][2];
        int indx = 0;

        while(i <= mid && j <= right){
            if (arr[i][0] > arr[j][0]){
                count[arr[i][1]] += right-j+1;
                temp[indx++] = arr[i];
                i++;
            } else {
                temp[indx++] = arr[j];
                j++;
            }
        }

        while(i <= mid){
            temp[indx++] = arr[i++]; 
        }

        while(j <= right){
            temp[indx++] = arr[j++];
        }

        int k = 0;
        while(left <= right){
            arr[left++] = temp[k++]; 
        }

    }



    private void mergeSort(int left, int right, int[][] arr, int[] count){
       
        if (left >= right) return;

        int mid = left + (right-left)/2;

        mergeSort(left, mid, arr, count);
        mergeSort(mid+1, right, arr, count);

        merge(left, mid, right, arr, count);

    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        // List<Integer> ans = new ArrayList<>();

        // for (int i = 0; i < n; i++){
        //     int num = nums[i];
        //     int count = 0;
        //     for (int j = i+1; j < n; j++){
        //         if (nums[j] < num) count ++;
        //     }

        //     ans.add(count);
        // }

        // return ans;

        int[]count = new int[n]; // isme ham apna answer store krayenge

        int[][] arr = new int[n][2]; // it has -> (num, index) -> index isliye cuz hame count array me index pe store karaana hai

        for (int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        mergeSort(0, n-1, arr, count);

        List<Integer> ans = new ArrayList<>();

        for (int c : count){
            ans.add(c);
        }

        return ans;


    }
}