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

        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            st.add(temp);
            temp = temp.next;
        }

        ListNode newhead = null;
        ListNode prev = null;

        while(!st.isEmpty()){
            temp = st.pop();
            System.out.println(temp.val);

            if (newhead == null) newhead = temp;
            if (prev != null) prev.next = temp;
            prev = temp;
        }
        temp.next = null;

        System.out.println(newhead.val);

        return newhead;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        int N = 0;
        ListNode temp = head;

        while(temp != null){
            N++;
            temp = temp.next;
        }

        HashMap<Integer, ListNode> hashing = new HashMap<>();
        int indx = 0;

        // System.out.println("index = " )
        temp = head;

        while(indx < N){
            hashing.put(indx , temp);
            indx += 2;
            temp = temp.next;
        }

        ListNode reverseHead = reverse(temp);
        indx = 1;
        

        while(reverseHead != null){
            // System.out.println("indx = " + indx + " " + reverseHead.);
            hashing.put(indx, reverseHead);
            indx += 2;
            reverseHead = reverseHead.next;
        }

        temp = head;
        indx = 0;
        while(indx < N-1){
            ListNode next = hashing.get(indx+1);
            temp.next = next;
            temp = next;
            indx ++;
        }

        temp.next = null;

        
        
    }
}