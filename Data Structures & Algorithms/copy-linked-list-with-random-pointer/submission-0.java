/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        HashMap<Node, Integer> nodeVsInd = new HashMap<>();
        HashMap<Integer, Integer> nodeIndVsRandInd = new HashMap<>();
        HashMap<Integer, Node> indVsNode = new HashMap<>();

        int ind = 1;
        Node dummy = head;
        while(dummy!=null){
            nodeVsInd.put(dummy, ind++);
            dummy = dummy.next;
        }

        dummy = head;
        while(dummy != null){
            nodeIndVsRandInd.put(nodeVsInd.get(dummy), nodeVsInd.get(dummy.random));
            dummy = dummy.next;
        }

        ind = 1;
        dummy = head;
        Node resD = new Node(0);
        Node cpy = resD;

        while(dummy != null){
            cpy.next = new Node(dummy.val);
            cpy = cpy.next;
            indVsNode.put(ind++, cpy);
            dummy = dummy.next;
        }

        for(int i:nodeIndVsRandInd.keySet()){
            indVsNode.get(i).random = indVsNode.get(nodeIndVsRandInd.get(i));
        }

        return resD.next;
    }
}
