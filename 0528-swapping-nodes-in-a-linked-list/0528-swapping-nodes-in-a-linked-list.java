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
    public ListNode swapNodes(ListNode head, int k) {
        // brute force:

        // find length of LL:
        int length = 0;
        ListNode temp = head;

        while(temp != null){
            temp = temp.next;
            length++;
        }

        int first = k;
        int second = length-k+1;

        ListNode node1 = null;
        ListNode node2 = null;

        temp = head;

        int i = 1;

        while(temp != null){
            if (i == first){
                node1 = temp;
            }

            if (i == second){
                node2 = temp;
            }
            temp = temp.next;
            i++;
        }

        if (node1 == null || node2 == null) return head;

        int tempval = node1.val;
        node1.val = node2.val;
        node2.val = tempval;

        return head;

    }
}