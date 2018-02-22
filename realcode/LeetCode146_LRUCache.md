### [LeetCode #146 - LRU Cache](https://leetcode.com/problems/lru-cache/description/)

### Thought
Use HashMap and Doubly Linked List
1. a *Node* is an object that stores key value pair, and also has link to previous and next nodes.
2. a *mapping* that maps integer key to node.
3. when we get an element
	* if element not in mapping, return -1
	* else we use mapping to find the corresponding *node*
		* remove the node in the linked list and readd it to the most requently used position, pointed by *tail*
4. when we put an element
	* if mapping already contains the key, we remove the corresponding node and readd it to tail
	* else we first check whether we have reached the capacity
		* if reached cap, remove least recently used node pointed to by *head*
		* add the new node to *tail*
```java
class LRUCache {
    private int cap, count;
    private Map<Integer, Node> mapping;
    private Node head, tail;

    class Node {
        private int key, val;
        private Node prev, next;
        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.count = 0;
        this.mapping = new HashMap<Integer, Node>();
        this.head = new Node(-1, -1, null, null);
        this.tail = new Node(-1, -1, null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public void removeNode(Node n) {
        --this.count;
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    public void addNode(Node n) {
        ++this.count;
        this.tail.prev.next = n;
        n.prev = this.tail.prev;
        n.next = this.tail;
        this.tail.prev = n;
    }
    
    public int get(int key) {
        if (!mapping.containsKey(key)) return -1;
        Node temp = mapping.get(key);
        removeNode(temp);
        addNode(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        if (mapping.containsKey(key)) {
            Node temp = mapping.get(key);
            removeNode(temp);
            Node toAdd = new Node(key, value, null, null);
            this.mapping.put(key, toAdd);
            addNode(toAdd);
        }
        else {
            if (this.count == this.cap) {
                this.mapping.remove(this.head.next.key);
                removeNode(this.head.next);
            }
            Node toAdd = new Node(key, value, null, null);
            this.mapping.put(key, toAdd);
            addNode(toAdd);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```
### Complexity 
O(1) get element & put element
O(N) space
### Notes
* use doubly linked list because deletion works on a single node
* Java LinkedHashMap has buildin support for LRU cache with appropriate constructors