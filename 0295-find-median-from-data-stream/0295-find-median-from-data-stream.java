class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;


    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        this.minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        
    }
    
    public void addNum(int num) {
        
        // jo bhi element aaye pehle use maxHeap me daalo:
        maxHeap.offer(num);

        // ab uska max uthaake minHeap me daal do:
        minHeap.offer(maxHeap.poll());

        // agar minHeap ka size badh jaye to wapas maxHeap me daal do:
        if (minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()){
            return (double) maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */