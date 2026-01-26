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
    public boolean isPalindrome(ListNode head) {
        // check if the reverse is same to the original
        if (head == null || head.next == null) return true;

        // find the middle:
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
             slow = slow.next;
             fast = fast.next.next;

        }

        prev.next = null;

        // reverse from slow:
        ListNode reversed = reverse(slow);

        ListNode temp = head;

        while(temp != null){
            if (temp.val != reversed.val) return false;
            temp = temp.next;
            reversed = reversed.next;
        }

        return true;



    }
}