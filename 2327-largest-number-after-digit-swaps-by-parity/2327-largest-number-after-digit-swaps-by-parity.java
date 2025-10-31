class Solution {
    private boolean sameParity(int n1, int n2){
        if (n1 % 2 == 0 && n2 % 2 == 0) return true;
        if (n1 % 2 != 0 && n2 % 2 != 0) return true;

        return false;
    }
    public int largestInteger(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        System.out.println(sb);

        for (int i = 0; i < sb.length(); i++){
            // swap the current number with the largest next number:
            char ch = sb.charAt(i);
            int max = i;
            for (int j = i+1; j < sb.length(); j++){
                 if (sb.charAt(j) > sb.charAt(max) && sameParity(sb.charAt(j)-'0', sb.charAt(max) - '0')){
                    max = j;
                 }
            }
            // swap ch with max:
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(max));
            sb.setCharAt(max, temp);
            System.out.println("str = " + sb);
         
        }

        return Integer.parseInt(sb.toString());
        
    }
}