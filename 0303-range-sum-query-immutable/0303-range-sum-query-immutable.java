class NumArray {
    
    int N;
    int segTree[];

    private void build(int[]nums, int indx, int low, int high){

       // base case:
       if (low == high){
         segTree[indx] = nums[low];
         return;
       }

        int mid = (low+ high)/2;

        // build left subtree at 2*indx + 1 having range from low to mid:
        build(nums, 2*indx+1, low, mid);

        // build right subtree at 2*indx + 2 having range from mid+1 to high
        build(nums, 2*indx+2, mid+1, high);

        segTree[indx] = segTree[2*indx+1] + segTree[2*indx+2];

    }
    public NumArray(int[] nums) {
        // create the segment tree:
        int n = nums.length; // total number of leaf nodes
        this.N = n; 
        this.segTree = new int[N*4];

        build(nums, 0, 0, n-1);
    }

    private int sumRange(int indx,int low, int high, int left, int right){

        // if it is out of bounds -> return 0:
        if (left > high || right < low) return 0;

        
        if (left <= low && right >= high){
           //  left   low....high   right
           return segTree[indx];
        }

         //if it lies completely inside the range:
         int mid = (low+high)/2;

         int q1 = sumRange(2*indx + 1, low, mid, left, right);
         int q2 = sumRange(2*indx + 2, mid+1, high, left, right);

         return q1+q2;
    }
    
    public int sumRange(int left, int right) {
        return sumRange(0, 0, N-1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */