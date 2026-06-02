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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode prev = null;
        ListNode h = null;

        if (list1.val < list2.val) {
            prev = list1;
            h = list1;
            list1 = list1.next;
        } else {
            prev = list2;
            h = list2;
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                prev = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                prev = list2;
                list2 = list2.next;
            }
        }

        prev.next = list1 != null ? list1 : list2;
        return h;
    }
}