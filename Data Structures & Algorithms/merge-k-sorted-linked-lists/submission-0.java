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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        boolean isNotNull = true;
        while (isNotNull) {
            isNotNull = false;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    pq.offer(lists[i].val);
                    lists[i] = lists[i].next;
                    isNotNull = true;
                }
            }
        }
        while (!pq.isEmpty()) {
            dummy.next = new ListNode(pq.poll());
            dummy = dummy.next;
        }
        return res.next;
    }
}
