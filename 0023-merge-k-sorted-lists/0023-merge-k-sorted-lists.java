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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < lists.length; i++){
            ListNode headnode = lists[i];
            if (headnode == null) continue;
            ListNode temp = headnode;

            while(temp != null){
                pq.add(temp);
                temp = temp.next;
            }

        }

        if (pq.isEmpty()) return null;

        ListNode head = pq.poll();
        ListNode temp = head;

        while(!pq.isEmpty()){
            ListNode newnode = pq.poll();
            temp.next = newnode;
            
            temp = temp.next;
        }
        temp.next = null;
        

        return head;
    }
}