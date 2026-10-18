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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;

        for(int i=0;i<lists.length;i++){
            result=mergeTwo(result,lists[i]);
        }
        return result;
    }
    public ListNode mergeTwo(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode current =dummy;
        while(temp1 != null && temp2 != null){
            
            if(temp1.val >= temp2.val){
                current.next=temp2;
                temp2= temp2.next;
            }
            else{
                current.next= temp1;
                temp1=temp1.next;
            }
           current= current.next; 
        }
        current.next = (temp1 != null) ? temp1 : temp2;

        return dummy.next;
    }
}