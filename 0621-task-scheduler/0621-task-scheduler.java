class Solution {

    private static class Task{
        char task;
        int remaining;
        int lastDone;

        public Task(char task, int remaining, int lastDone){
            this.task = task;
            this.remaining = remaining;
            this.lastDone = lastDone;
        }
    }
    public int leastInterval(char[] tasks, int n) {
       HashMap<Character, Integer> taskmap = new HashMap<>();
       int size = tasks.length;

       for (int i = 0; i < size; i++){
        taskmap.put(tasks[i], taskmap.getOrDefault(tasks[i], 0) +1);
       }

       PriorityQueue<Task> queue = new PriorityQueue<>((a ,b) ->{

        if (a.remaining != b.remaining){
            return b.remaining - a.remaining;
        }

        return a.lastDone - b.lastDone;


       });

       

       for (Character task : taskmap.keySet()){
           queue.add(new Task(task, taskmap.get(task), -1));
        //    System.out.println(task);
       }
       int currentTime = 1;

    while(!queue.isEmpty()){
        Task currentTask = null;

        int s = queue.size();
        List<Task> tempList = new ArrayList<>();

          for (int i = 0; i < s; i++){
              Task temp = queue.poll();
              int lastDone = temp.lastDone;
              if (lastDone == -1 || currentTime - lastDone > n){
                  currentTask = temp;
                  break;
              }
              tempList.add(temp);
          }

          for (Task t : tempList){
            queue.offer(t);
          }

          if (currentTask == null){
            currentTime++;
            continue;
          }

         
          currentTask.remaining --;
          currentTask.lastDone = currentTime;

          if (currentTask.remaining > 0){
            queue.offer(currentTask);
          }

          if (queue.isEmpty()) break;


          currentTime ++;

       }

       return currentTime;


    }
}