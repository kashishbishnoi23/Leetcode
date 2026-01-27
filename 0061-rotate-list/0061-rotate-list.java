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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) return head;
         

        ListNode temp = head;
        int total = 0;

        while(temp != null){
           temp = temp.next;
           total ++;
        }

        k %= total;
        if (k == 0) return head;
        // find the kth node by the end:
        ListNode slow = head;
        ListNode fast = head;

        int count = 0;

        while(fast != null && count < k){
            fast = fast.next;
            count ++;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }


        ListNode newhead = slow.next;
        slow.next = null;

        ListNode end = fast;

        end.next = head;

        return newhead;



    }
}