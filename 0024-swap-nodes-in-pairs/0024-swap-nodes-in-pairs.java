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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode newhead = head.next;
        ListNode prev = null;

        while(temp != null && temp.next != null){
            ListNode next = temp.next.next;
            if (prev != null){
                prev.next = temp.next;
            }
            temp.next.next = temp;
            temp.next = next;
            prev = temp;
            temp = next;
        }

        return newhead;
    }
}