class Solution {

    // private int merge(int[] arr, int start, int mid, int end){
    //     long[] first = new long[mid-start+1];
    //     long[] second = new long[end-mid];
        
    //     int indx = 0;
    //     for (int i = start; i <= mid; i++){
    //         first[indx++] = arr[i];
    //     }
        
    //     indx = 0;
    //     for (int j = mid+1; j <= end; j++){
    //         second[indx++] = arr[j];
    //     }
        
    //     int i = 0;
    //     int j = 0;
        
    //     int count = 0;
        
    //     while(i < first.length && j < second.length){
    //         if (first[i] > 2*second[j]){
    //             count += first.length-i;
    //             j++;
    //         } else {
    //             i++;
    //         }
    //     }
        
    //     long[]third = new long[end-start+1];
        
    //     indx = 0;
        
    //     i = 0;
    //     j = 0;
        
    //     while(i < first.length && j < second.length){
    //         if (first[i] < second[j]){
    //             third[indx++] = first[i++];
    //         } else {
    //             third[indx++] = second[j++];
    //         }
    //     }
        
    //     while(i < first.length){
    //         third[indx++] = first[i++];
    //     }
        
    //     while(j < second.length){
    //         third[indx++] = second[j++];
    //     }
        
    //     indx = 0;
    //     for (int k = start; k <= end; k++){
    //         arr[k] = (int)third[indx++];
    //     }
        
    //     return count;
        
    // }
    
    // private int mergeSort(int[] arr, int start, int end){
        
    //     int count = 0;
    //     if (start >= end) return 0;
    //     int mid = start + (end-start)/2;
        
    //     count += mergeSort(arr, start, mid);
    //     count += mergeSort(arr, mid+1, end);
        
    //     count += merge(arr, start, mid, end);
        
    //     return count;
        
    // }

    
    private int merge(int[] nums, int left, int mid, int right){

        int[] temp = new int[right-left+1];

        int i = left;
        int j = mid+1;
        int count = 0;
        int indx = 0;

        while(i <= mid && j <= right){
            if (nums[i] > 2L*nums[j]){
                count += right-j+1;
                i++;
            } else {
                j++;
            }
        }

        i = left;
        j = mid+1;
        while(i <= mid && j <= right){
            if (nums[i] > nums[j]){
                temp[indx++] = nums[i++];
            } else{
                temp[indx++] = nums[j++];
            }
        }

        while(i <= mid){
            temp[indx++] = nums[i++];
        }

        while(j <= right){
            temp[indx++] = nums[j++];
        }

        int k = 0;

        int l = left;

        while(l <= right){
            nums[l++] = temp[k++];
        }


        return count;

    }

    private int mergeSort(int[] nums, int left, int right){

        if (left >= right) return 0;
        int count = 0;

        int mid = left + (right-left)/2;

        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid+1, right);

        count += merge(nums, left, mid, right);

        // System.out.println(left + " " + right + " " + count);

        return count;

    }
    


    public int reversePairs(int[] nums) {
        int n = nums.length;

        // same as count of smaller numbers after self:

        return mergeSort(nums, 0, n-1);
    }
}