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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ListNode l3 = new ListNode(-1);
        // ListNode temp = l3;
        
        
        // int carry = 0;
        // while(l1 != null && l2 != null){
        //     int sum = l1.val + l2.val + carry;
        //     temp.next = new ListNode(sum % 10);

        //     carry = sum > 9 ? 1 : 0;
        //     l1 = l1.next;
        //     l2 = l2.next;
        //     temp = temp.next;

        // }

        // while(l1 != null){
        //     int sum = l1.val + carry;
        //     temp.next =  new ListNode(sum % 10);
        //     carry = sum > 9 ? 1 : 0;
        //     temp = temp.next;
        //     l1 = l1.next;
        // }

        // while(l2 != null){
        //     int sum = l2.val + carry;
        //     temp.next =  new ListNode(sum % 10);
        //     carry = sum > 9 ? 1 : 0;
        //     temp = temp.next;
        //     l2 = l2.next;
        // }

        // if (carry == 1) temp.next = new ListNode(1);

        // return l3.next;



        ListNode l3head = new ListNode(-1);
        ListNode l3 = l3head;
        int carry = 0;
        while(l1 != null && l2 != null){
            int num1 = l1.val;
            int num2 = l2.val;
            int sum = num1 + num2;
            int val = sum + carry;

            l3.next = new ListNode(val % 10);
            carry = val/10;
            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;

        }

        while(l1 != null){
            int val = l1.val + carry;
            l3.next = new ListNode(val % 10);
            carry = val/10;
            l1 = l1.next;
            l3 = l3.next;
        }

        while(l2 != null){
            int val = l2.val + carry;
            l3.next = new ListNode(val % 10);
            carry = val/10;
            l2 = l2.next;
            l3 = l3.next;
            
        }

        if (carry > 0){
            l3.next = new ListNode(carry);
        }

        return l3head.next;









    }
}