class Solution {

    // build max range segment tree:
    int[] segTree;

    private void build(int indx, int low, int high, int[] heights){

        if (low == high){
            // we at root node:
            segTree[indx] = heights[low];
            return;
        }

        int mid = (low + high)/2;

        // build left subtree"
        build(2*indx+1, low, mid, heights);

        // build right subtree:
        build(2*indx+2, mid+1, high, heights);

        segTree[indx] = Math.max(segTree[2*indx+1], segTree[2*indx+2]);
    }

    private int query(int indx, int low, int high, int left, int right,  int[] segTree){

        // out of bounds:
        if (right < low || left > high) return Integer.MIN_VALUE;

        if (low >= left && high <= right) return segTree[indx];

        int mid = (low + high)/2;

        int q1 = query(2*indx+1, low, mid, left, right, segTree);
        int q2 = query(2*indx+2, mid+1, high, left, right, segTree);

        return Math.max(q1, q2);

    }



    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] ans = new int[queries.length];
        int indx = 0;

        segTree = new int[4*n];

        build(0, 0, n-1, heights);

        for (int [] query : queries){
            int alice = query[0];
            int bob = query[1];
            int rightindx = alice > bob ? alice : bob;
            int leftindx = alice < bob ? alice : bob;
            int max = Math.max(heights[alice], heights[bob]);

           if(alice == bob){
            ans[indx++] = alice;
           } else if (heights[rightindx] > heights[leftindx]){
               ans[indx++] = rightindx;
           } else {
              int start = rightindx + 1;
              int end = n-1;
              int ansindx = -1;

              while(start <= end){
                int mid = start + (end-start)/2;

                int temp = query(0, 0, n-1, start, mid , segTree);

                if (temp > max){
                    ansindx = mid;
                    end = mid-1;
                } else {
                    start = mid+1;
                }
              }

              ans[indx++] = ansindx;

           }

            
        }

        return ans;
    }
}