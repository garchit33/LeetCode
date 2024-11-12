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
        // if(n==0 || head == null);
        //     return head;

        ListNode root = new ListNode(0);
        root.next = head;
        ListNode slow = root, fast = root;
        int count = 0;
        while(count<=n){
            fast=fast.next;
            count++;
        }

        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return root.next;
    }
}