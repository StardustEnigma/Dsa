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

        if(head == null || head.next == null || k==0){
            return head;
        }
        ListNode temp=head;
        int length=1;
        while(temp.next != null){
            temp =temp.next;
            length++;
        }
        k= k % length;

        if(k == 0){
            return head;
        }
        temp.next=head;
        
        int newTail = length-k-1;

        temp = head;
        while(newTail != 0){
            temp=temp.next;
            newTail--;
        }
        head= temp.next;
        temp.next=null;

     return head;
    }
}