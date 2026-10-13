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
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;

        ListNode temp = head;
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode moreHead=more;
        ListNode lessHead=less;
        while(temp!=null){
            int curr = temp.val;
            temp=temp.next;

            if(curr<x){
                less.next=new ListNode(curr);
                less=less.next;
            }
            else{
                more.next=new ListNode(curr);
                more=more.next;
            }
        }

        less.next=moreHead.next;
        return lessHead.next;
    }
}