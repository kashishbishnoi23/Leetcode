class RangeFreqQuery {
    
    int N;
    HashMap<Integer, Integer>[] segTree;

    private void build(int indx, int low, int high, int[] arr){
        
        if (low == high){
            HashMap<Integer, Integer> hashing = new HashMap<>();
            hashing.put(arr[low], 1);
            segTree[indx] = hashing; 
            return;
        }
        // calculate for left:
        int mid = (low+high)/2;

        build(2*indx+1, low, mid, arr);
        
        build(2*indx+2, mid+1, high, arr);

        HashMap<Integer, Integer> hashing = new HashMap<>();

        HashMap<Integer, Integer> lhashing = segTree[2*indx+1];
        HashMap<Integer, Integer> rhashing = segTree[2*indx+2];

        if (lhashing != null){
            for (int key : lhashing.keySet()){
                // hashing.merge(key, lhashing.get(key), Integer::sum);
                if (hashing.containsKey(key)){
                    hashing.put(key, hashing.get(key) + lhashing.get(key));
                } else {
                    hashing.put(key, lhashing.get(key));
                }
            }
        }

        if (rhashing != null){
            for (int key: rhashing.keySet()){
                // hashing.merge(key, rhashing.get(key), Integer::sum);

                if (hashing.containsKey(key)){
                    hashing.put(key, hashing.get(key) + rhashing.get(key));
                } else {
                    hashing.put(key, rhashing.get(key));
                }
            }
        }

        segTree[indx] = hashing;


    }
    public RangeFreqQuery(int[] arr) {
        int n = arr.length;
        this.N = n;
        segTree = new HashMap[4*N];

        build(0, 0, n-1, arr);
    }

    private int query(int indx, int low, int high, int left, int right, int value){

        if (left > high || right < low) return 0;

        if (low >= left && high <= right){
            int ans = 0;
            HashMap<Integer, Integer> hashing = segTree[indx];
            if (hashing != null){
                for (int key : hashing.keySet()){
                    if (key == value){
                        ans += hashing.get(key);
                    }
                }
            }
            return ans;
        }


        int mid = (low+ high)/2;

        int q1 = query(2*indx+1, low, mid, left, right, value);
        int q2 = query(2*indx+2, mid+1, high, left, right, value);

        return q1+q2;
    }

    public int query(int left, int right, int value) {
        
        return query(0, 0, N-1, left, right, value);
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */