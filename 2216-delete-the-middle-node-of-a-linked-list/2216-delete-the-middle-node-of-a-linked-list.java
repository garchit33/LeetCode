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
    public ListNode deleteMiddle(ListNode head) {
        ListNode root = head;
        if(head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevSlow = null;
        while(fast!=null && fast.next!=null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nextSlow = slow.next;
        prevSlow.next = nextSlow;
        return root;
    }
}