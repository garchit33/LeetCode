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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = new ListNode(-101);
        ListNode root = prev;

        while(head != null){
            if(prev.val == head.val){
                head = head.next;
            }else {
                prev.next = head;
                prev = prev.next;
            }
        }
        prev.next = null;
        return root.next;
    }
}