class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;


    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        this.minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        // agar mera current element -> maxHeap ke sabse bade element se chhota hai to current maxHeap me jayega aur maxHeap ka max minHeap me jayega -> isliye ham pehle maxHeap me num ko dalenge -> fir uska max nikalke minHeap me daal denge

        // ab max element uthaake minHeap me daalo:
        minHeap.offer(maxHeap.poll());

        // minHeap ka size maxHeap k barabar (even number of elements) ya kam rkhna hai (for odd number of elements):
        if (minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
         if (maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
         } else {
            return maxHeap.peek();
         }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */