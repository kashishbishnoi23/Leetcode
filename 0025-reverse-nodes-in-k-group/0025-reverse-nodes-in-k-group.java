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

    private ListNode reverse(ListNode head){
    
       if (head.next == null) return head;
       ListNode next = head.next;
       ListNode newhead = reverse(head.next);
        
       next.next = head;
       return newhead;


    }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode newhead = null;
        ListNode prev = null;

        while(temp != null){
            ListNode start = temp;

            int count = 1;
            while(temp != null && count < k){
                temp = temp.next;
                count++;
            }

            if (newhead == null) newhead = temp;
            if (temp == null) break;

            ListNode next = temp.next;
            temp.next = null;
            ListNode reverseHead = reverse(start);
            if (prev != null){
                prev.next = reverseHead;
            }
            prev = start;

            start.next = next;
            temp = next;
        }

        return newhead;
    }
}