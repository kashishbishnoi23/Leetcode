class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        ArrayList<ArrayList<Character>> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++){
            list.add(new ArrayList<>());
        }
        
        int row = 0;
        int j = 0;

        while(j < s.length()){   
           
           // go down:      
           while(j < s.length() && row < numRows){
              list.get(row).add(s.charAt(j++));
              row++;
           }

           // go up:
           row -= 2;

           while(j < s.length() && row >= 0){
              list.get(row).add(s.charAt(j++));
              row --;
           }

           row += 2;

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++){
            for (int k = 0; k < list.get(i).size();k++){
                sb.append(list.get(i).get(k));
            }
        }

        return sb.toString();

        
    }
}