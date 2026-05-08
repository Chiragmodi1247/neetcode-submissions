class LRUCache {
    public static class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private final int cacheCapacity;
    private final Node head = new Node(0,0), tail = new Node(0,0);
    private final HashMap<Integer, Node> nodeMap = new HashMap<>();

    public LRUCache(int capacity) {
        cacheCapacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        remove(node);
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            remove(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            addToHead(node);
            if(nodeMap.size() > cacheCapacity) {
                Node removalNode = tail.prev;
                remove(removalNode);
                nodeMap.remove(removalNode.key);
            }
        }
    }
}
