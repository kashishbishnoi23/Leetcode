class Solution {
    public int firstUniqChar(String s) {
        int index = -1;

        int [] array = new int [26];

        for (int i = 0; i < s.length(); i++){
            array[s.charAt(i)-97] ++;
        }

        // for (int value : array){
        //     System.out.print(value + " ");
        // }

        for (int j = 0; j < s.length(); j++){
            if (array[s.charAt(j)-97] == 1){
                return j;
            } 
        }

        return index;

    }
}