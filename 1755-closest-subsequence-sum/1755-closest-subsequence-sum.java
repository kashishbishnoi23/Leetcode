class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;

        // is case me we don't care about the length -> so ham simply left half me left k sare subset sums rkhenge aur right me right side ke -> each will have 2^(n/2) length 

        ArrayList<Integer> left = new ArrayList<>();

        ArrayList<Integer> right = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if (i % 2 == 0){
                left.add(nums[i]);
            } else {
                right.add(nums[i]);
            }
        }

        ArrayList<Integer> leftSums = new ArrayList<Integer>();

        ArrayList<Integer> rightSums = new ArrayList<Integer>();

        generateSubsetSums(left, leftSums, 0, 0);
        generateSubsetSums(right, rightSums, 0, 0);
        int ans = Integer.MAX_VALUE;

        Collections.sort(rightSums);

        for (int rightsum : rightSums){
            ans = Math.min(ans, Math.abs(goal - rightsum));
        }

        // now we'll see -> if leftsum alone or rightsum alone or both together -> milke goal ke kitna paas ja sakte hain

        for (int leftsum : leftSums){
             ans = Math.min(ans, Math.abs(leftsum - goal));

            //  for (int rightsum : rightSums){
            //     ans = Math.min(ans, Math.abs(rightsum - goal));
            //     int x = leftsum + rightsum;
            //     ans = Math.min(ans, Math.abs(x - goal));
            //  }

            int target = goal - leftsum;

            // find the closest sum to target in rightsum 
            int indx = binarySearch(rightSums, target);
            int closestR = 0;

            if(indx >= 0 && indx < rightSums.size() && rightSums.get(indx) == target){
                 return 0;
            } else {
                // these are insertion points:
                if (indx == 0 ){
                   // this is the closest
                   closestR = rightSums.get(indx);
                } else if (indx == -1){
                    closestR = rightSums.get(indx+1);
                } else if (indx == rightSums.size()){
                    closestR = rightSums.get(indx-1);
                } else {
                    // we have two close:
                    int smaller = rightSums.get(indx-1);
                    int larger = rightSums.get(indx);

                    if (Math.abs(smaller - target) < Math.abs(larger - target)){
                        closestR = smaller;
                    } else {
                        closestR = larger;
                    }
                }

            }

            ans = Math.min(ans, Math.abs(target - closestR));


        }

        return ans;





    }

    private void generateSubsetSums(ArrayList<Integer> arr, ArrayList<Integer> result, int indx, int sum){

        if (indx == arr.size()){
            result.add(sum);
            return;
        }

        // include the curr element:

        generateSubsetSums(arr, result, indx+1, sum+arr.get(indx));


        // exclude the curr element:
        generateSubsetSums(arr, result, indx+1, sum);

    }

    private int binarySearch(ArrayList<Integer> rightSums, int target){
        int l = 0;
        int r = rightSums.size()-1;

        while(l <= r){
            int mid = l + (r-l)/2;

            if (rightSums.get(mid) == target) return mid;

            if (rightSums.get(mid) > target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        // return the insertion point:
        return l;
    }
}