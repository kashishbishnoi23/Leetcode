class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        int[] res = new int[n+m]; // max length of ans:

        for (int i = n-1; i >= 0; i--){
            for (int j = m-1; j >= 0; j--){
                int mul = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');

                // curr digit -> res[i+j+1]
                int sum = mul + res[i+j+1];

                res[i+j+1] = sum % 10;
                res[i+j] += sum/10;
            }
        }

        StringBuilder sb = new StringBuilder();

        int indx = 0;

        while(indx < m+n-1 && res[indx] == 0){
            indx++;
        }

        while(indx < m+n){
            sb.append(res[indx++]);
        }

        return sb.toString();
    }

}