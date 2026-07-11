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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = head;
        if(head == null)
            return null;

        ListNode initHead = new ListNode(-1);
        int pos = 1;
        while(pos < left){
            initHead = head;
            head = head.next;
            pos++;
        }

        ListNode temp = head;
        ListNode[] arr = reverseLinkedList(head, right, pos);
        initHead.next = arr[0];
        temp.next = arr[1];

        if(left == 1)
            return initHead.next;
        
        return root;
    }

    private ListNode[] reverseLinkedList(ListNode head, int right, int pos) {
        ListNode prev = null;
        while(pos <= right){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;

            pos++;
        }
        return new ListNode[]{prev, head};
    }
}