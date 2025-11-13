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
            return null;

        int count = 0;

        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null){
            fast = fast.next;
            count++;
        }
         k%=count;
         fast = head;
         while(k > 0){
            fast = fast.next;
            k--;
         }

         while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
         }

         fast.next = head;
         head = slow.next;
         slow.next = null;

         return head;
    }
}