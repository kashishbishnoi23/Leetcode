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
        // HashSet<ListNode> st = new HashSet<>();

        // ListNode temp = headA;
        // while(temp != null){
        //     st.add(temp);
        //     temp = temp.next;
        // }

        // temp = headB;

        // while(temp != null){
        //     if (st.contains(temp)) return temp;
        //     temp  = temp.next;
        // }

        // return null;

        int count1 = 0;
        ListNode temp1 = headA;

        while(temp1 != null){
            count1 ++;
            temp1 = temp1.next;
        }

        int count2 = 0;
        ListNode temp2 = headB;

        while(temp2 != null){
            count2 ++;
            temp2 = temp2.next;
        }

        int diff = Math.abs(count1 - count2);
        temp1 = headA;
        temp2 = headB;

        if (count1 > count2){
            
            while(diff > 0){
                temp1 = temp1.next;
                diff --;
            }
        } else {
            while(diff > 0){
                temp2 = temp2.next;
                diff --;
            }
        }

        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
    }
}