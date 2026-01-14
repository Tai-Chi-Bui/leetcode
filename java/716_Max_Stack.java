/*
 * Problem: 716. Max Stack
 * 
 * Description:
 * Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.
 * Implement the MaxStack class:
 * - MaxStack() Initializes the stack object
 * - void push(int x) Pushes element x onto the stack
 * - int pop() Removes the element on top of the stack and returns it
 * - int top() Gets the element on the top of the stack without removing it
 * - int peekMax() Retrieves the maximum element in the stack without removing it
 * - int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one
 * 
 * Requirements:
 * - Support standard stack operations (push, pop, top)
 * - Support peekMax() to get maximum without removing
 * - Support popMax() to remove and return maximum
 * 
 * Example:
 * Input: ["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"]
 *        [[], [5], [1], [5], [], [], [], [], [], []]
 * Output: [null, null, null, null, 5, 5, 1, 5, 1, 5]
 * 
 * Constraints:
 * - -10^7 <= x <= 10^7
 * - At most 10^4 calls will be made to push, pop, top, peekMax, and popMax
 * - There will be at least one element in the stack when pop, top, peekMax, or popMax is called
 */

class MaxStack {
    TreeMap<Integer, List<Node>> map;
    DoubleLinkedList dll;

    public MaxStack() {
        map = new TreeMap();
        dll = new DoubleLinkedList();
    }

    public void push(int x) {
        Node node = dll.add(x);
        if(!map.containsKey(x))
            map.put(x, new ArrayList<Node>());
        map.get(x).add(node);
    }

    public int pop() {
        int val = dll.pop();
        List<Node> L = map.get(val);
        L.remove(L.size() - 1);
        if (L.isEmpty()) map.remove(val);
        return val;
    }

    public int top() {
        return dll.peek();
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = peekMax();
        List<Node> L = map.get(max);
        Node node = L.remove(L.size() - 1);
        dll.unlink(node);
        if (L.isEmpty()) map.remove(max);
        return max;
    }
}

class DoubleLinkedList {
    Node head, tail;

    public DoubleLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public Node add(int val) {
        Node x = new Node(val);
        x.next = tail;
        x.prev = tail.prev;
        tail.prev = tail.prev.next = x;
        return x;
    }

    public int pop() {
        return unlink(tail.prev).val;
    }

    public int peek() {
        return tail.prev.val;
    }

    public Node unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }
}

class Node {
    int val;
    Node prev, next;
    public Node(int v) {val = v;}
}
