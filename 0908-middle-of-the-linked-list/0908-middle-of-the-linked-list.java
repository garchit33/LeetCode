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
    public ListNode middleNode(ListNode head) {
        int mid =  countNodes(head)/2;
        // if(countNodes(head) % 2 == 0){
        //     mid = mid + 1;
        // }
        ListNode middle = head;
        for(int i =0; i<mid; i++){
            if(middle.next != null){
                middle = middle.next;
            }
        }
        return middle;
    }
    
    int countNodes(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}