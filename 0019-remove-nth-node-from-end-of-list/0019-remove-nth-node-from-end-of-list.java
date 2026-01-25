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
        // int total = 0;

        // ListNode temp = head;
        // while(temp != null){
        //     total++;
        //     temp = temp.next;
        // }

        // int k = total-n;
        // if (k == 0) return head.next;
        // int count = 1;
        // temp = head;

        // while(count < k){
        //     temp = temp.next;
        //     count ++;
        // }
        // if (temp.next != null){
        //     temp.next = temp.next.next;
        // }

        // return head;

        // one-pass:

        // 2 pointers lo -> slow and fast 

        // fast ko n steps chalao => ab fast slow se n steps aage hai -> ab slow aur fast ko ek sath chalao -> jase hi fast null hoga -> slow fast se n steps peeche hoga -> yani end se n steps peeche

       ListNode slow = head;
       ListNode fast = head;

       int count = 0;

       while(count < n){
           fast = fast.next;
           count++;
       }

       // if fast is null -> n is the length of linked list -> we want to delete the head
       if (fast == null) return head.next;

       while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
       }

       slow.next = slow.next.next;

       return head;









    }
}