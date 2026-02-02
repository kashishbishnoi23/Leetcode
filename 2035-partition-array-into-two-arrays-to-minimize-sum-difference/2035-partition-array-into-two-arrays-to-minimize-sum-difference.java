class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length/2;

        int total = 0;
        for (int a : nums){
            total += a;
        }

        // divide into 2 arrays -> left and right:
        int[] left = Arrays.copyOfRange(nums,0, n);
        int[] right = Arrays.copyOfRange(nums,n, 2*n);
        
        // left me -> kis length pe kitna sum mil skta hai -> vo calculate kro:
        ArrayList<ArrayList<Integer>> leftArraySums = new ArrayList<>();
        ArrayList<ArrayList<Integer>> rightArraySums = new ArrayList<>();

        for (int i = 0; i <= n; i++){
            leftArraySums.add(new ArrayList<>());
            rightArraySums.add(new ArrayList<>());
        }


        // now length is n -> so we can generate 2^n combinations / subsets -> vo sare combinations ke sums -> length k according store krao in left and right array sums

        for (int mask = 0; mask < (1 << n); mask++){
            int size = 0;
            int sum = 0;
            for (int i = 0; i < n; i++){
                // can I take the ith index??
                if ((mask & (1 << i)) != 0){
                    size ++;
                    sum += left[i];
                }
            }

            leftArraySums.get(size).add(sum);
        }

        for (int mask = 0; mask < (1 << n); mask++){
            int size = 0;
            int sum = 0;
            for (int i = 0; i < n; i++){
                // can I take the ith index??
                if ((mask & (1 << i)) != 0){
                    size ++;
                    sum += right[i];
                }
            }

            rightArraySums.get(size).add(sum);
        }

        for (int i = 0; i <= n; i++){
            Collections.sort(rightArraySums.get(i));
        }
        
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++){

            // i is the size/ number of elements I will pick from the left array
            for (int sum : leftArraySums.get(i)){
                // ith size pe ye ye sums available hain:

                int leftSum = sum;
                int req = n-i;

                // pick the best sum from rightArraySums such that leftSum + rightSum is closer to total/2
                int target = total/2 - leftSum;
                ArrayList<Integer> rightSums = rightArraySums.get(req);

                int index = binarySearch(rightSums, target);
                int closestR = 0;

                if (index >= 0 && index < rightSums.size() && rightSums.get(index) == target){
                    return (total % 2 == 0) ? 0 : 1;
                } else {
                    // index is the insertion point of that target:
                    if (index == rightSums.size()){
                        closestR = rightSums.get(index-1);
                    } else if (index == 0) {
                        closestR = rightSums.get(index);
                    } else if (index == -1){
                        closestR = rightSums.get(index+1);
                    } else {

                        int smallest = rightSums.get(index-1);
                        int largest = rightSums.get(index);

                        if (Math.abs(target - smallest) < Math.abs(target - largest)){
                            closestR = smallest;
                        } else {
                            closestR = largest;
                        }
                    }
                }

                int x = leftSum + closestR;

                ans = Math.min(ans, Math.abs(total-2*x));







            }
        }

        return ans;

    }

    private int binarySearch(ArrayList<Integer> rightSums, int target){

        int start = 0;
        int end = rightSums.size()-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if (rightSums.get(mid) == target) return mid;

            if (rightSums.get(mid) > target){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return start;



    }


}