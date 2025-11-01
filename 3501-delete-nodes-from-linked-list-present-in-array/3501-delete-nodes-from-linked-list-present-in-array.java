/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        int n = nums.length;
        ListNode newhead = new ListNode(-1);
        newhead.next = head;

        Set<Integer> st = new HashSet<>();
        for (int num : nums){
            st.add(num);
        }

        // for (int i = 0; i < n; i++){
        //     int num = nums[i];
        //     ListNode temp = newhead;
        //     while(temp != null){
        //         ListNode node = temp;
        //         while (node.next != null && node.next.val == num){
        //             node = node.next;
        //         }
        //         temp.next = node.next;
        //         temp = temp.next;
        //     }
        // }


        ListNode temp = newhead.next;
        ListNode prev = newhead;
        while(temp != null){
            while(temp != null && st.contains(temp.val)){
                temp = temp.next;
            }
            prev.next = temp;
            prev = temp;
            if (temp == null) break;
            temp = temp.next;
                 
        }
        return newhead.next;
    }
}