class KthLargest {

    // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int limit = 0;

    public KthLargest(int k, int[] nums) {
        // push all of them to maxHeap -> uske baad top k elements ko minHeap me daaldo -> ab jo minHeap ka minimum hoga vo hamara Kth largest number hoga

        this.limit = k;
        // for (int num : nums){
        //     maxHeap.offer(num);
        // }


        // while(minHeap.size() < k && !maxHeap.isEmpty()){
        //     minHeap.offer(maxHeap.poll());
        // }

        for (int num : nums){

            if (minHeap.size() >= limit){
                if (num > minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(num);
                }
            } else {
                minHeap.offer(num);
            }
    }
    }
    
    public int add(int val) {
        // ab jo value ayegi -> agar vo minHeap k minimum se badi hai -> to vo Largest k elements ka part (jo nayi value ayi h) hai -> use ham minHeap me rkhenge , aur minHeap ki minimum value ko maxHeap me daal denge:

        // if (minHeap.size() < limit){
        //     // put the value in maxHeap -> take the largest Kth from minHeap:
        //     maxHeap.offer(val);

        //     minHeap.offer(maxHeap.poll());

        //     return minHeap.peek();
        // }

        // if (val > minHeap.peek()){
        //    maxHeap.offer(minHeap.poll());
        //    minHeap.offer(val);
        // } else {
        //     maxHeap.offer(val);
        // }

        // if (minHeap.size() < limit) return -1;

        // return minHeap.peek();


// optimised -> bhai seedha sa ek hi minHeap maintain kar -> usme bas k elements hi rkh -> jo k largest elements hai -> to like pehle usme k elements daal -> fir jo nayi value aati hai agar vo un k elements ke minimum se badi hai -> to vo value largest k elements ka part hai -> so minHeap k minimum ko nikal aur usme nayi value ko daal de

        if (minHeap.size() < limit){
            minHeap.offer(val);
        } else {
            if (val > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(val);
            }
        }

        if (minHeap.size() < limit) return -1;
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */