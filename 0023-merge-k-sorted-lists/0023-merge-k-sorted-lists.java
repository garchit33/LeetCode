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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode node : lists){
            if(node!=null)
                pq.offer(node);
        }
        
        ListNode result = new ListNode(0);
        ListNode root = result;
        while(pq.size() > 0){
            ListNode rm = pq.poll();
            result.next = rm;
            if(rm.next != null)
                pq.offer(rm.next);
            result = result.next;
        }
        return root.next;
    }
}