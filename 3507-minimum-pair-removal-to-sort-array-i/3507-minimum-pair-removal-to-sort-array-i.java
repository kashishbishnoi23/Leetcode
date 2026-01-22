class Solution {

    private boolean isSorted(ArrayList<Integer> arr){
        int n = arr.size();

        for (int i = 0; i < n-1; i++){
            int a = arr.get(i);
            int b = arr.get(i+1);

            if (b < a) return false;
        }

        return true;
    }

 
    public int minimumPairRemoval(int[] nums) {
        int op = 0;

        ArrayList<Integer> arr = new ArrayList<>();

        for (int num : nums){
            arr.add(num);
        }

        while(!isSorted(arr)){
            int minSum = Integer.MAX_VALUE;
            int indx = -1;

            for (int i = 0; i < arr.size()-1; i++){
                int sum = arr.get(i) + arr.get(i+1);

                if (sum < minSum){
                    minSum = sum;
                    indx = i;
            // System.out.println(indx + " " + arr.get;

                }
            }


            arr.remove(indx);
            arr.set(indx, minSum);
            op++;

            // for (int a : arr){
            //     System.out.print(a + " ");
            // }
            // System.out.println();


        }

        return op;
        
    }
}