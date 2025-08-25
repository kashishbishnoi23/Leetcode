class Solution {

    // private void recursive(int index, int n, List<Integer> temp, List<List<Integer>> ans, int[] nums){

    //     if (index == n){
    //         // ans.add(temp);
    //         return;
    //     }
        
    //     for (int i = index; i < n; i++){
    //         if (i > index && nums[i] == nums[i-1]) continue;
    //         temp.add(nums[i]);
    //         ans.add(new ArrayList<>(temp));
    //         recursive(i+1, n, temp, ans, nums);
    //         temp.remove(temp.size()-1); 
    //     }
    // }
    

    private void recursive(int index, int[] nums, Set<List<Integer>> st, ArrayList<Integer> temp){
        int n = nums.length;
        if (index == n){
            Collections.sort(temp);
            st.add(new ArrayList<>(temp));
            return;
        }

        // pick current element:
        temp.add(nums[index]);
        recursive(index+1, nums, st, temp);


        // do not pick current element:
        temp.remove(temp.size()-1);
        recursive(index+1, nums, st, temp);
    }

    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        // List<List<Integer>> ans = new ArrayList<>();
        // Arrays.sort(nums); // sorting is important bruhh!!
        // int n = nums.length;
        // List<Integer> temp = new ArrayList<>();
        // recursive(0, n, temp, ans, nums);
        // ans.add(new ArrayList<>());
        // return ans;
     
        Arrays.sort(nums);
        HashSet<List<Integer>> st = new HashSet<>();
        ArrayList<Integer> temp = new ArrayList<>();
        recursive(0, nums, st, temp);

        List<List<Integer>> ans = new ArrayList<>();

        for (List<Integer> t : st){
            ans.add(t);
        }
        return ans;
    }
}