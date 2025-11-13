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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = getCount(head);
        count/=k;

        ListNode root = new ListNode(-1);
        ListNode temp = root;
        for(int i=0; i<count; i++){
            ListNode arr[] = reverse(head,k);
            temp.next = arr[0];
            temp = head;
            head = arr[1];
        }

        temp.next = head;
        return root.next;
    }

    private ListNode[] reverse(ListNode head, int k){
        ListNode prev = null;
        ListNode root = head;
        while(k-->0){
            ListNode temp = root.next;
            root.next = prev;
            prev = root;
            root = temp;
        }
        return new ListNode[]{prev,root};
    }

    private int getCount(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}