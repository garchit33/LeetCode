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
            return root;

        ListNode initialHead = new ListNode(-1);
        int pos = 1;
        while(pos < left){
            initialHead = head; //Prev Node to Node from where the LinkedList needs to be reversed
            head = head.next;
            pos++;
        }

        ListNode temp = head; //Node from where the LinkedList needs to be reversed
        ListNode[] arr = reverse(head, pos, right);
        initialHead.next = arr[0]; //Prev Node to Node from where the LinkedList needs to be reversed will point to Prev returned by reverse function
        temp.next = arr[1]; //Node from where the LinkedList needs to be reversed will point to head returned by reverse function

        if(left == 1)
            return initialHead.next; //if linkedlist need to be reversed from 1st position then return prev from reverse function

        return root;
    }

    private ListNode[] reverse(ListNode head, int pos, int right){
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