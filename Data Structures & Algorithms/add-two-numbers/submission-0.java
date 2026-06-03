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
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        int rmdr = 0;
        while(l1 != null || l2 != null || rmdr == 1){
            int sum = rmdr;
            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            if(sum-10 >= 0){
                sum %= 10;
                rmdr = 1;
            } else {
                rmdr = 0;
            }

            res.next = new ListNode(sum);
            res = res.next;
        }

        return dummy.next;
    }
}