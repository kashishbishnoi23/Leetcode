class Solution {
    public int minimumDifference(int[] nums) {
               int n = nums.length / 2;
        int totalSum = 0;
        for (int x : nums) totalSum += x;

        // Split array
        int[] leftArr = Arrays.copyOfRange(nums, 0, n);
        int[] rightArr = Arrays.copyOfRange(nums, n, 2 * n);

        // left[k] = all subset sums taking k elements from leftArr
        List<Integer>[] left = new ArrayList[n + 1];
        List<Integer>[] right = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        // Generate subsets for left
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0, count = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += leftArr[i];
                    count++;
                }
            }
            left[count].add(sum);
        }

        // Generate subsets for right
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0, count = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += rightArr[i];
                    count++;
                }
            }
            right[count].add(sum);
        }

        // Sort right lists for binary search
        for (int i = 0; i <= n; i++) {
            Collections.sort(right[i]);
        }

        int ans = Integer.MAX_VALUE;

        // Combine
        for (int k = 0; k <= n; k++) {
            for (int leftSum : left[k]) {
                int need = totalSum / 2 - leftSum;
                List<Integer> rList = right[n - k];

                int idx = Collections.binarySearch(rList, need);
                if (idx < 0) idx = -idx - 1;

                if (idx < rList.size()) {
                    int sum = leftSum + rList.get(idx);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * sum));
                }
                if (idx > 0) {
                    int sum = leftSum + rList.get(idx - 1);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * sum));
                }
            }
        }

        return ans;


     


    }
}