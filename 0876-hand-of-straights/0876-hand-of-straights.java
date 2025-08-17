class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int size = hand.length;
        if (size % groupSize != 0) return false;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : hand){
            pq.offer(num);
        }

        // pick out the smallest:
        while(!pq.isEmpty()){
            int prev = pq.poll();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 1; i < groupSize; i++){
                while(!pq.isEmpty() && pq.peek() == prev){
                    temp.add(pq.poll());
                }
                if (pq.isEmpty()) return false;
                int number = pq.poll();
                if (number != prev+1) return false;
                prev = number;
            }

            for (int num : temp){
                pq.offer(num);
            }

            temp.clear();
        }

        return true;
    }
}