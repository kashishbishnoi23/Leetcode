class Solution {
    public boolean isHappy(int n) {
        // StringBuilder sb = new StringBuilder(String.valueOf(n));
        String st = String.valueOf(n);
        HashSet<Integer> s = new HashSet<>();

        while(true){
            int sum = 0;

            for (int i = 0; i < st.length(); i++){
                int a = st.charAt(i) - '0';
                sum += a*a;
            }

            if (sum == 1) return true;

            st = String.valueOf(sum);
            System.out.println(sum);

            if (s.contains(sum)) return false;

            s.add(sum);


        }

        // return false;


    }
}