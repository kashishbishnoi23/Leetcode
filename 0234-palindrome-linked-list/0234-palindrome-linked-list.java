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
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newhead = reverse(head.next);
        next.next = head;
        head.next = null;
        return newhead;
    }
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // reverse LL from slow:
        ListNode reverseHead = reverse(slow);

        ListNode temp1 = head;
        ListNode temp2 = reverseHead;

        while(temp1 != null && temp2 != null){
            if (temp1.val != temp2.val) return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }


        return true;


        


    }
}