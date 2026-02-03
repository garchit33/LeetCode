class LFUCache {
    class Node {
        Node prev, next;
        int key, value, cnt;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.cnt = 1;
        }
    }
    
    class Dll {
        Node head, tail;
        int size;
        public Dll(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void add(Node node){
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
            size++;
        }

        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node = null;
            size--;
        }

        public Node removeLast() {
            if(size > 0){
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    int capacity, size, min;
    Map<Integer, Node> nodeMap;
    Map<Integer, Dll> cntMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        cntMap = new HashMap<>();
        min = 0;
        size = 0;
    }
    
    public int get(int key) {
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            update(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity == 0)
            return;
        
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.value = value;
            update(node);
        }else {
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            if(size == capacity){
                Dll dll = cntMap.get(min);
                Node lastNode = dll.removeLast();
                nodeMap.remove(lastNode.key);
                size--;
            }
            size++;
            min = 1;
            Dll dll = cntMap.getOrDefault(node.cnt, new Dll());
            dll.add(node);
            cntMap.put(node.cnt, dll);
        }
    }

    private void update(Node node){
        Dll dll = cntMap.get(node.cnt);
        dll.remove(node);
        if(node.cnt == min && dll.size == 0)
            min++;
        node.cnt++;
        dll = cntMap.getOrDefault(node.cnt, new Dll());
        dll.add(node);
        cntMap.put(node.cnt, dll);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */