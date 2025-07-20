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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode grtr = new ListNode(-1);
        ListNode h1 = less;
        ListNode h2 = grtr;
        while(head != null){
            if(head.val < x){
                less.next = head;
                head = head.next;
                less = less.next;
            }else {
                grtr.next = head;
                head = head.next;
                grtr = grtr.next;
            }
        }

        grtr.next = null;
        less.next = h2.next;

        return h1.next;
    }
}