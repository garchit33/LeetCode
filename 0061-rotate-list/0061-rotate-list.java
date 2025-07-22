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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while(fast != null){
            fast = fast.next;
            count++;
        }
        fast = head;
        k%=count;
        while(k>0){
            fast = fast.next;
            k--;
        }

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}