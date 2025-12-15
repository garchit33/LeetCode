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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode prev = result;
        int carry = 0;

        while(l1 != null || l2 != null){
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int sum = val1+val2+carry;
            int newNodeVal = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(newNodeVal);
            prev.next = node;
            prev = prev.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if(carry != 0){
            ListNode node = new ListNode(carry);
            prev.next = node;
            prev = prev.next;
        }

        prev.next = null;
        return result.next;        
    }
}