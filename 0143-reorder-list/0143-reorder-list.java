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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        head2 = reverseLinkList(head2);
        slow.next = null;

        //printList(head);
       // printList(head2);

        mergeList(head, head2);
    }

    void printList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private ListNode mergeList(ListNode head1, ListNode head2){
        ListNode root = head1;
        while(head2 != null){
            ListNode temp = head1.next;
            ListNode temp2 = head2.next;
            head1.next = head2;
            head2.next = temp;
            head1 = temp;
            head2 = temp2;
        }
        return root;
    }

    private ListNode reverseLinkList(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

}