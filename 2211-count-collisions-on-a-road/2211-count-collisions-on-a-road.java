class Solution {

    
    public int countCollisions(String directions) {
        int collisions = 0;

        int flag = -1; // number of cars moving towards right, -1 matlab no cars moving towards right

        for (int i = 0; i < directions.length(); i++){
            char ch = directions.charAt(i);

            if (ch == 'R'){
                   if (flag == -1){
                    flag = 1;
                   } else {
                    flag ++;
                   }
            } else if (ch == 'L'){
                if (flag >= 0){
                    collisions += 1 + flag;
                    flag = 0;
                }
            } else {
                if (flag > 0){
                    collisions += flag;
                }
                flag = 0;

            }
        }

        return collisions;



       
    }
}