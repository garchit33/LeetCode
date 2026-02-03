class LRUCache {
    class Node {
        int key, value;
        Node next, prev;
        public Node(int key, int value){
            this.key = key;
            this.value = value; 
        }
    }

    Node head, tail;
    int capacity, size;
    Map<Integer, Node> nodeMap;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        nodeMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node == null)
            return -1;
        deleteNode(node);
        addNode(key, node.value);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            deleteNode(node);
        }
        
        addNode(key,value);
        if(size > capacity){
            deleteNode(tail.prev);
        }
    }

    private void addNode(int key, int value){
        Node node = new Node(key, value);
        nodeMap.put(key, node);
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        size++;
    }

    private void deleteNode(Node node){
        nodeMap.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
        size--;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */