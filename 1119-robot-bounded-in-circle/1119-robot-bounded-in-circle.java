class Solution {
    private String anticlock(String direction){
         switch (direction){
            case "north":
               return "west";
            case "south":
               return "east";
            case "east":
               return "north";
            case "west":
               return "south";
         }
         return "";
    }

    private String clock(String direction){
        switch(direction){
            case "north":
               return "east";
            case "south":
               return "west";
            case "east":
               return "south";
            case "west":
               return "north";
        
        }

        return "";
    }

    public boolean isRobotBounded(String instructions) {
        // if we reach (0, 0) again, return true, else return false:
        int n = instructions.length();
        int x = 0;
        int y = 0;
        String direction = "north";
        for (int j = 0; j < 4; j++){
        for (int i = 0; i < n; i++){
            char ch = instructions.charAt(i);
            if (ch == 'G'){
               if (direction == "north"){
                  y++;
               } else if (direction == "south"){
                  y--;
               } else if (direction == "east"){
                x++;
               } else {
                x--;
               }
            } else {
                if (ch == 'L'){
                 direction  =  anticlock(direction);
                } else {
                    direction = clock(direction);
                }
            }

        }
        }

        if (x == 0 && y == 0) return true;
        return false;
    }
}