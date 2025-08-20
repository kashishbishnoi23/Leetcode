class LRUCache {
    
    private static class Pair{
        int key;
        int value;
        int time;

        public Pair(int key, int value, int time){
            this.key = key;
            this.value = value;
            this.time = time;
        }
    };

    PriorityQueue <Pair>pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
    int currTime = 0;
    int capacity = 0;

    Map<Integer, Pair> hashing = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!hashing.containsKey(key)) return -1;
        currTime ++;
        Pair p = hashing.get(key);
        pq.remove(p);
        p.time = currTime;
        pq.offer(p);
        return p.value;
    }
    
    public void put(int key, int value) {
        if (hashing.size() == capacity && !hashing.containsKey(key)){
            // remove the one which was used least recently:
            Pair p = pq.poll();
            hashing.remove(p.key);
        }
        currTime++;
        if (hashing.containsKey(key)){
            Pair p = hashing.get(key);
            p.value = value;
            pq.remove(p);
            p.time = currTime;
            pq.offer(p);
            return;
        }
        Pair p = new Pair(key, value,currTime);

        hashing.put(key, p);
        pq.offer(p);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */