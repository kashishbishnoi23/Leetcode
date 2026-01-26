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
    public int pairSum(ListNode head) {

        HashMap<Integer, Integer> hashing = new HashMap<>();

        ListNode temp = head;
        int n = 0;
        int indx = 0;
        while(temp != null){
            hashing.put(indx, temp.val);
            temp = temp.next;
            n++;
            indx++;
        }

        int max = 0;

        for (int key : hashing.keySet()){
            System.out.println(key);
            max = Math.max(max, hashing.get(key) + hashing.get(n-1-key));
        }

        return max;
        
    }
}