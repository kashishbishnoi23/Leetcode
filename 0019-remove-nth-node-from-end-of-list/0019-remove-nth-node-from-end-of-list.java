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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total = 0;

        ListNode temp = head;
        while(temp != null){
            total++;
            temp = temp.next;
        }

        int k = total-n;
        if (k == 0) return head.next;
        int count = 1;
        temp = head;

        while(count < k){
            temp = temp.next;
            count ++;
        }
        if (temp.next != null){
            temp.next = temp.next.next;
        }

        return head;
    }
}