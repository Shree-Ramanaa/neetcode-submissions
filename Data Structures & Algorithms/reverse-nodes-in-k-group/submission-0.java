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
        ListNode dummy = new ListNode(0, head);
        ListNode grpPrev = dummy;
        
        while(true){
            ListNode kth = getKth(grpPrev, k);
            if(kth == null){
                break;
            }

            ListNode grpNext = kth.next;
            grpPrev.next = kth;
            ListNode cur = head, prev = grpNext, nxt = head.next;

            while(head != grpNext){
                head.next = prev;
                prev = head;
                head = nxt;
                if(head != null)nxt = head.next;   
            }

            grpPrev = cur;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
