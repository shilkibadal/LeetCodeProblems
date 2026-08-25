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
    ListNode temp=head;
    int count=0;
    while(temp!=null){
    count++;
    temp=temp.next;
    }
    int middle=count/2;

    ListNode curr=head;
    for(int i=0;i<middle;i++){
        curr=curr.next;
    }
    return curr;
    }
}