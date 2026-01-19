class NumArray {
    
    int N;
    int[] segTree;

    private void build(int indx, int low, int high, int[] nums){
        
        // base case:
        if (low == high){
            segTree[indx] = nums[low];
            return;
        }

        int mid = (low + high)/2;

        // build the left subtree:
        build(2*indx+1, low, mid, nums);

        // build the right subtree:
        build(2*indx+2, mid+1, high, nums);

        segTree[indx] = segTree[2*indx+1] + segTree[2*indx+2];

    }
    public NumArray(int[] nums) {
        int n = nums.length;
        this.N = n;
        this.segTree = new int[4*N];
         
        build(0, 0, n-1, nums);
        
    }

    private void update(int index, int val, int indx,  int low, int high){
        if (low == high){
            // we have reached the element that needs to be updated:
            segTree[indx] = val;
            return;
        }
    

        int mid = (low+high)/2;
        if (index <= mid){
            // left subtree me hoga:
            update(index, val, 2*indx+1, low, mid);
        } else{
            update(index, val, 2*indx+2, mid+1, high);
        }

        segTree[indx] = segTree[2*indx+1] + segTree[2*indx+2];
        

    }

    
    public void update(int index, int val) {
        update(index, val, 0, 0, N-1);
    }

    private int sumRange(int indx, int low, int high, int left, int right){

        if (left > high || right < low) return 0; // out of bounds case:

        if (left <= low && right >= high) return segTree[indx];

        int mid = (low+high)/2;

        int q1 = sumRange(2*indx+1, low, mid, left, right);
        int q2 = sumRange(2*indx+2, mid+1, high, left, right);

        return q1+q2;
    }
    
    public int sumRange(int left, int right) {
        return sumRange(0, 0, N-1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */