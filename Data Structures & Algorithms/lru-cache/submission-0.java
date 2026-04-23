class LRUCache {

    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private int myCapacity;
    private Node head;
    private Node tail;
    HashMap<Integer, Node> nodeMap;

    public LRUCache(int capacity) {
        myCapacity = capacity;
        nodeMap = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    private void addToHead(Node node) {
        Node temp = head.next;
        head.next = node;
        temp.prev = node;
        node.next = temp;
        node.prev = head;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node curr = nodeMap.get(key);
        moveToHead(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(nodeMap.containsKey(key)) {
            Node curr = nodeMap.get(key);
            curr.val = value;
            moveToHead(curr);
            return;
        }
        if(nodeMap.size() == myCapacity) {
            Node lru = tail.prev;
            nodeMap.remove(lru.key);
            removeNode(tail.prev);
        }
        Node newNode = new Node(key, value);
        nodeMap.put(key, newNode);
        addToHead(newNode);
    }
}
