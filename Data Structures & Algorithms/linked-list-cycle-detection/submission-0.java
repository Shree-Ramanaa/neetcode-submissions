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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode sp = head, fp = head.next;

        while(sp != null){
            if(sp == fp){
                return true;
            }

            if(fp.next == null || fp.next.next == null){
                return false;
            }

            sp = sp.next;
            fp = fp.next.next;
        }

        return false;
    }
}
