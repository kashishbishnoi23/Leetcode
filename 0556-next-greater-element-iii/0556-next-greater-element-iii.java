class Solution {
    public int nextGreaterElement(int n) {
        // next largest permutation:

        String number = String.valueOf(n);
        int index = -1;
        System.out.println(number);

        for (int j = number.length()-2 ; j >= 0; j--){
            // System.out.println(j);
            if (number.charAt(j) < number.charAt(j+1)){
                index = j;
                break;
            }
        }

        System.out.println("index = " + index);

        if (index == -1) return -1;
        StringBuilder sb = new StringBuilder(number);

        // find the index jisse index ko swap krna hai -> just greater than index:
        int swap = -1;
        for (int j = number.length()-1; j >= 0; j--){
            if (number.charAt(j) > number.charAt(index)){
                swap = j;
                break;
            }
        }

        // swap index with last index:
        char temp = number.charAt(swap);
        sb.setCharAt(swap, sb.charAt(index));
        sb.setCharAt(index, temp);
        System.out.println(sb);
        String newstr = sb.toString();

        // sort the string after index:

        String substring = newstr.substring(index+1);

        char[] arr = substring.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);

        String ans = newstr.substring(0, index+1) + sorted;

        // return ans;
        int num = -1;
        try{
          num = Integer.valueOf(ans);
        } catch(Exception e){
           num = -1;
        }

        return num;



        

    }
}