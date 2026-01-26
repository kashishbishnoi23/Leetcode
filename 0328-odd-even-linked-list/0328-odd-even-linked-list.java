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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode temp1 = oddHead;
        ListNode temp2 = evenHead;
        ListNode prev = null;

        while(temp2 != null){
            prev = temp1;
            temp1.next = temp1.next.next;
            temp2.next = temp2.next == null ? null : temp2.next.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if (temp1 == null){
            prev.next = evenHead;
        } else {
            temp1.next = evenHead;
        }

       

        return oddHead;

        


    }
}