class Solution {
    public int scheduleCourse(int[][] courses) {
        
        // store the max duration of already done courses
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        int count = 0;
        ArrayList<int[]> list = new ArrayList<>();

        for (int [] course : courses){
            list.add(new int[] {course[0], course[1]});
        }

        Collections.sort(list, (a, b) -> Integer.compare(a[1], b[1]));
        int curr = 0;

        for (int i = 0; i < list.size(); i++){
            int[] course = list.get(i);
            int duration = course[0];
            int lastday = course[1];


            if (curr + duration > lastday){
                // swap it with an already done course which took the maximum time
                if (pq.isEmpty()) continue;

                int[] front = pq.peek();
                int dur = front[0];
                if (dur < duration) continue;
                pq.poll();
                curr -= dur;
            } else {
                count ++;
            }

                curr += duration;
                pq.offer(course);
            }
        return count;
            

            
        






    }
}