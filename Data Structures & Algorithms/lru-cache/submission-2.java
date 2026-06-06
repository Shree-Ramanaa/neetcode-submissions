class LRUCache {
    private static class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int size;
    Node head = null, tail = null;
    HashMap<Integer, Node> keyVsNode = new HashMap<>();

    public LRUCache(int capacity) {
        size = capacity;
    }

    public int get(int key) {
        if (keyVsNode.containsKey(key)) {
            setFreqNode(key);
            return keyVsNode.get(key).val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (keyVsNode.containsKey(key)) {
            keyVsNode.get(key).val = value;
            setFreqNode(key);
        } else {
            Node entry = new Node(key, value);
            keyVsNode.put(key, entry);

            if (head == null) {
                tail = entry;
                head = entry;
                return;
            }

            entry.next = head;
            head.prev = entry;
            head = entry;

            // evict when size exceeds
            if (size < keyVsNode.size()) {
                tail.prev.next = null;
                keyVsNode.remove(tail.key);
                tail = tail.prev;
            }
        }
    }

    private void setFreqNode(int key) {
        Node fr = keyVsNode.get(key);

        if (fr == head) {
            return;
        }

        if (fr == tail) {
            tail = fr.prev;
        }
        fr.prev.next = fr.next;

        if (fr.next != null) {
            fr.next.prev = fr.prev;
        }

        fr.next = head;
        head.prev = fr;
        fr.prev = null;
        head = fr;
    }
}
