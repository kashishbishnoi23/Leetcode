/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        // store the nodes of one LL in a set, traverse through the second LL -> whichever common node comes first -> return 
        HashSet<ListNode> st = new HashSet<>();

        ListNode temp = headA;
        while(temp != null){
            st.add(temp);
            temp = temp.next;
        }

        temp = headB;

        while(temp != null){
            if (st.contains(temp)) return temp;
            temp  = temp.next;
        }

        return null;
    }
}