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
    public ListNode sortList(ListNode head) {
        List<Integer> list= new ArrayList<>();
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp=head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        temp=head;
        Collections.sort(list);
        int index=0;

        while(temp != null){
            temp.val=list.get(index);
            temp = temp.next;
            index++;
        }
        return head;
    }
}