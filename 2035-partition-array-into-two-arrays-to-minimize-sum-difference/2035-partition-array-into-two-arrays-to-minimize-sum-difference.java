class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;

        // basically, hame n size ke 2 subsets chahiye -> jinke sum ka difference minimum ho -> maanlo n size k ek subset ka sum x hai -> to dusre bache hue elements ka sum S-x ho jayega where S is the total sum of all elements -> we need to minimize -> (S-x) - x = S - 2x , so ham sirf n elements ke liye har possible x nikalenge -> aur har possible S-2x ki value nikalenge and the minimum will be our answer

        // iske liye ham nums ko 2 parts me baantenge => left and right => each will have n elements -> ab left subset me har size k liye we will find all the possible sums 

        // for example, we have nums => {3,9,7,3}
        // left = {3, 9}  right = {7, 3}

        // ab left subset ke liye -> for size 0, only possible sum is 0
        // for size 1 -> {3, 9}
        // for size 2 -> {12}

        // so for left subset we have -> {{0}, {3, 9}, {12}}

        // now -> if I pick 0 elements from left, I need to pick n from right subset , in that way I will make a subset of {7, 3}

        // if I pick 1 element from left -> eg, 3, I can pick 1 from right, so we will get 2 sums (x ) -> 3 + 7 = 10 and 3 + 3 = 6
        // and so on..., this is how we create all the x values 

        int total = 0;
        for (int num : nums){
            total += num;
        }

        int[] leftArr = Arrays.copyOfRange(nums, 0, n);
        int[] rightArr = Arrays.copyOfRange(nums, n, 2*n );

        ArrayList<ArrayList<Integer>> left = new ArrayList<>();
        ArrayList<ArrayList<Integer>> right = new ArrayList<>();

        for (int i = 0; i <= n; i++){
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }

        // Generate subsets for left: total 2^n combinations possible
        for (int mask = 0; mask <= (1 << n); mask++){
            int size = 0;
            int sum = 0;
            for (int i = 0; i < n; i++){
                if (((1 << i) & mask) != 0){
                    size ++;
                    sum += leftArr[i];
                }
            }
            left.get(size).add(sum);
        }
        
        // Generate subsets for right:
        for (int mask = 0; mask <= (1 << n); mask++){
            int size = 0;
            int sum = 0;

             for (int i = 0; i < n; i++){
                if (((1 << i) & mask) != 0){
                    size ++;
                    sum += rightArr[i];
                }
            }
            right.get(size).add(sum);

        }

        for (int i = 0; i <= n; i++){
            Collections.sort(right.get(i));
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++){
            for (int leftSum : left.get(i)){
                // i length pe ye sum hai -> leftSum

                // now I need a sum of length n-i

                int reqLength = n-i;
                ArrayList<Integer> rightSums = right.get(reqLength);

                // int x = leftSum;

                // for (int rightSum : rightSums){
                //     x = leftSum + rightSum;
                //     ans = Math.min(ans, Math.abs(total - 2*x));
                // }

                // find the best rightSum -> closer to target , where target is total/2 - x(leftsum)

                int target = total/2 - leftSum;
                // Collections.sort(rightSums);
                int x = 0;
                int closestR = 0;

                int indx = binarySearch(rightSums, target);

                if (indx >= 0 && indx < rightSums.size() && rightSums.get(indx) == target){
                    // ans = Math.min(ans, );
                    return total % 2 == 0 ? 0 : 1;

                } else {
                    // we have got insertion point 
                    if (indx == rightSums.size()){ // yani target is greater than all the sums -> so x should be rightSums.get(indx-1)
                        closestR = rightSums.get(indx-1);
                    } else if (indx == -1){
                        closestR = rightSums.get(indx+1);
                    } else if (indx == 0){
                        closestR = rightSums.get(indx);
                    }
                    else {
                        // we have two points -> indx -1 and indx + 1

                        int smaller = rightSums.get(indx-1);
                        int larger = rightSums.get(indx);

                        if (Math.abs(target - smaller) < Math.abs(target - larger)){
                            closestR = smaller;
                        } else {
                            closestR = larger;
                        }
                    }
                }

                // ans = Math.min(ans,  total/2 )
                x = leftSum + closestR;

                ans = Math.min(ans, Math.abs(total-2*x));


            }
        }

        return ans;

    }

    private int binarySearch(ArrayList<Integer> rightSum, int target){
        int l = 0;
        int r = rightSum.size()-1;

        while(l <= r){
            int mid = l + (r-l)/2;

            if (rightSum.get(mid) == target){
                return mid; // if found -> we return the index where it is found
            } else if (rightSum.get(mid) < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // if exact number is not found -> we have our l and r 

        // where does l point to ?? -> the insertion point  iske peeche ka element is smaller than target -> iske aage ka 


        return l;




    }
}