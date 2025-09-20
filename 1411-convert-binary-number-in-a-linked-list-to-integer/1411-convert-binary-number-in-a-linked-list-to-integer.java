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
    public int getDecimalValue(ListNode head) {
        
        // get the binary number:
        int number = 0;
        ListNode temp = head;

        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        temp = head;

        int indx = size-1;
        while(temp != null){
            int bit = temp.val;
            number += (1 << indx)*bit;
            temp = temp.next;
            indx--;
        }

        return number;

    }
}