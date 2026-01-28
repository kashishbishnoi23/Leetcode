class MKAverage {

    Queue<Integer> q; // maintain only the last m elements
    TreeMap<Integer, Integer> hashing; // ye numbers ko sorted order me rkhege aur unka count bhi store krayega -> basically hame un m elements me smallest aur largest element pata hoga

    // ek total sum maintain krege -> m elements ka -> us sum me se smallest k aur largest k elements ka sum minus kar denge -> hame bache hue elements ka sum mil jayega -> jisse ham average nikaal skte hain
    int m;
    int k;
    int totalSum;
    int totalSize;


    public MKAverage(int m, int k) {
           this.q = new LinkedList<>();
           this.m = m;
           this.k = k;
           this.totalSum = 0;
           this.totalSize = 0;
           this.hashing = new TreeMap<>();
        
    }
    
    public void addElement(int num) {
        q.offer(num);
        totalSum += num;
        totalSize ++;
        if (q.size() > m){
            // aage se element pop krlo:
            int front = q.poll();
            totalSum -= front;
            hashing.merge(front, -1 , Integer:: sum);
            if (hashing.get(front) == 0) hashing.remove(front);
        } 
        hashing.merge(num, 1 , Integer::sum);
    }

 
    public int calculateMKAverage() {
        if (q.size() < m) return -1;

        // now we have m elements:
        int extremeSum = 0;

        int kSmall = k;
        int kLarge = k;
        int key = hashing.firstKey(); // sabse chhoti key

        while(kSmall > 0){
            int count = Math.min(hashing.get(key), kSmall);
            extremeSum += count*key;
            kSmall -= count;
            if (kSmall == 0) break;
            key = hashing.higherKey(key); // apne aap agli key pe chala jayega

        }

        int lastKey = hashing.lastKey(); // ye last key hogi -> sabse bada number

        while(kLarge > 0){
            int count = Math.min(kLarge, hashing.get(lastKey));
            extremeSum += count*lastKey;
            kLarge -= count;
            if (kLarge == 0) break;
            lastKey = hashing.lowerKey(lastKey);

        }

        int ret = (totalSum - extremeSum)/(m-2*k);

        return ret;



        
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */