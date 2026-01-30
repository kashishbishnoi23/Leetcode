class NumArray {

    int N;
    int[] segTree;
    int[] nums;

    public NumArray(int[] nums) {
        this.N = nums.length;
        this.segTree = new int[4*N];

        build(0, N-1, 0, nums);
        this.nums = nums;
    }

    public void build(int left, int right, int indx, int[] nums){

        if (left > right) return;

        if (left == right){
            // leaf node:
            segTree[indx] = nums[left];
            return;
        }

        int mid = left + (right-left)/2;

        // left sum:
        build(left, mid, 2*indx+1, nums);

        // right sum:
        build(mid+1, right, 2*indx+2, nums);

        segTree[indx] = segTree[2*indx+1] + segTree[2*indx+2]; 
    }

    public void update(int left, int right, int indx, int index, int val){
        
        // out of bound:
        if (index < left || index > right) return;

        if (left == right){
            nums[left] = val;
            segTree[indx] = val;
            return;
        }

        int mid = left + (right-left)/2;

        if (index <= mid){
            // go to left:
            update(left, mid, 2*indx+1, index, val);
        } else {
            // go to right:
            update(mid+1, right, 2*indx+2, index, val);
        }

        segTree[indx] = segTree[2*indx+1] + segTree[2*indx+2];

    }
   
    public void update(int index, int val) {
        update(0, N-1, 0, index, val);
    }

    public int sumRange(int left, int right, int indx, int start, int end, int[] nums){

        // handle out of range:
        if (left > end || right < start) return 0;

        if (start == end) return nums[start];

        if (left <= start && end <= right){
            return segTree[indx];
        }

        int mid = start + (end - start)/2;

        int leftSum = sumRange(left, right, 2*indx+1, start, mid, nums);
        int rightSum = sumRange(left, right, 2*indx+2, mid+1, end, nums);

        return leftSum + rightSum;

    }
    
    public int sumRange(int left, int right) {
        return sumRange(left, right, 0, 0, N-1, nums);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */